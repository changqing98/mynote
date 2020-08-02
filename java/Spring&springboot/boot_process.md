# SpringBoot——启动过程剖析

[toc]

## 1. 应用初始化

### 1.1 SpringBoot应用启动

```java
  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
```

SpringBoot应用的启动首先需要构造一个SpringApplication及进行一些初始化操作。

```java
    public static ConfigurableApplicationContext run(Class<?> primarySource, String... args) {
        return run(new Class<?>[] { primarySource }, args);
    }

    public static ConfigurableApplicationContext run(Class<?>[] primarySources, String[] args) {
        // 首先初始化一个SpringApplication
        return new SpringApplication(primarySources).run(args);
    }
```

```java
    public SpringApplication(Class<?>... primarySources) {
        this(null, primarySources);
    }

    public SpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
        // 由上面一个方法进来，该处的resourceLoader为null
        this.resourceLoader = resourceLoader;
        Assert.notNull(primarySources, "PrimarySources must not be null");
        // 一般来说就是我们的启动类，即@SpringBootApplication注解标注的启动类
        this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
        // 推断web应用类型，源码分析请参考1.2节
        this.webApplicationType = WebApplicationType.deduceFromClasspath();
        // 设置初始化器，这里是一个很重要的过程，获取Spring工厂实例，加载并下的spring.factories文件
        // 源码分析请参考1.3节
        setInitializers((Collection) getSpringFactoriesInstances(ApplicationContextInitializer.class));
        // 设置监听器，实现原理与设置初始化器类似
        setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
        // 推断应用主类
        this.mainApplicationClass = deduceMainApplicationClass();
    }
```

### 1.2 Web应用类型类型推断

```java
    static WebApplicationType deduceFromClasspath() {
        // WEBFLUX_INDICATOR_CLASS = "org.springframework.web.reactive.DispatcherHandler
        // WEBMVC_INDICATOR_CLASS = "org.springframework.web.servlet.DispatcherServlet";
        // JERSEY_INDICATOR_CLASS = "org.glassfish.jersey.servlet.ServletContainer";
        if (ClassUtils.isPresent(WEBFLUX_INDICATOR_CLASS, null) 
        && !ClassUtils.isPresent(WEBMVC_INDICATOR_CLASS, null)
                && !ClassUtils.isPresent(JERSEY_INDICATOR_CLASS, null)) {
              // Reactive Web应用
            return WebApplicationType.REACTIVE;
        }
        // SERVLET_INDICATOR_CLASSES = { "javax.servlet.Servlet",
        // "org.springframework.web.context.ConfigurableWebApplicationContext" }
        for (String className : SERVLET_INDICATOR_CLASSES) {
            if (!ClassUtils.isPresent(className, null)) {
                // 非Web应用
                return WebApplicationType.NONE;
            }
        }
        // ServletWeb应用
        return WebApplicationType.SERVLET;
    }
```

### 1.3 getSpringFactoriesInstances

```java
    private <T> Collection<T> getSpringFactoriesInstances(Class<T> type) {
        return getSpringFactoriesInstances(type, new Class<?>[] {});
    }

    private <T> Collection<T> getSpringFactoriesInstances(Class<T> type, Class<?>[] parameterTypes, Object... args) {
        // 获取类加载器，AppClassLoader
        ClassLoader classLoader = getClassLoader();
        // Use names and ensure unique to protect against duplicates
        // 获取全部的Spring的工厂实现类的全限定名，这一部分实现十分重要
        // 源码分析请参考1.4节
        Set<String> names = new LinkedHashSet<>(SpringFactoriesLoader.loadFactoryNames(type, classLoader));
        // 通过反射的方式，实例化所有的工厂类
        List<T> instances = createSpringFactoriesInstances(type, parameterTypes, classLoader, args, names);
        // 对实例化的工厂实例进行排序
        AnnotationAwareOrderComparator.sort(instances);
        return instances;
    }
```

### 1.4 SpringFactoriesLoader

```java
    /**
     * Load the fully qualified class names of factory implementations of the
     * given type from {@value #FACTORIES_RESOURCE_LOCATION}, using the given
     * class loader.
     * @param factoryType the interface or abstract class representing the factory
     * @param classLoader the ClassLoader to use for loading resources; can be
     * {@code null} to use the default
     * @throws IllegalArgumentException if an error occurs while loading factory names
     * @see #loadFactories
     */
    public static List<String> loadFactoryNames(Class<?> factoryType, @Nullable ClassLoader classLoader) {
    // 根据上文所述，分别要进行factoryType为ApplicationContextInitializer.class 和 ApplicationListener.clas的加载
    // 获取工厂类型的全限定名
    String factoryTypeName = factoryType.getName();
        // classLoader: AppClassLoader
        // 返回对应工厂类型的所有实现类
        return loadSpringFactories(classLoader).getOrDefault(factoryTypeName, Collections.emptyList());
    }

    private static Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader) {
        MultiValueMap<String, String> result = cache.get(classLoader);
        // 先从缓存中读取该类加载器的加载结果
        if (result != null) {
            return result;
        }

        try {
            // FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories"
            // 加载类路径下（所有Jar包）的META-INF/spring.factories文件
            Enumeration<URL> urls = (classLoader != null ?
                    classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
                    ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));
            // LinkedMultiValueMap的数据结构为Map<String,List<String>>
            result = new LinkedMultiValueMap<>();
            // 解析META-INF/spring.factories将其转换成LinkedMultiValueMap描述的数据结构
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                UrlResource resource = new UrlResource(url);
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                for (Map.Entry<?, ?> entry : properties.entrySet()) {
                    String factoryTypeName = ((String) entry.getKey()).trim();
                    for (String factoryImplementationName : StringUtils.commaDelimitedListToStringArray((String) entry.getValue())) {
                        result.add(factoryTypeName, factoryImplementationName.trim());
                    }
                }
            }
            // 解析结果写入缓存
            cache.put(classLoader, result);
            return result;
        }
        catch (IOException ex) {
            throw new IllegalArgumentException("Unable to load factories from location [" +
                    FACTORIES_RESOURCE_LOCATION + "]", ex);
        }
    }
```

* spring.factories

  META-INF/spring.factories文件简单来说就是spring一系列接口及实现类的声明，类似于java的SPI机制，SpringClassLoader解析该文件，将其转换成LinkedMultiValueMap类型的数据结构，键为接口的全限定名，值为实现类的全限定名List。下面是spring-boot jar文件下面的META-INF/spring.factories文件的部分代码样例。

  ```java
    # Application Context Initializers
    org.springframework.context.ApplicationContextInitializer=\
    org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer,\
    org.springframework.boot.context.ContextIdApplicationContextInitializer,\
    org.springframework.boot.context.config.DelegatingApplicationContextInitializer,\
    org.springframework.boot.rsocket.context.RSocketPortInfoApplicationContextInitializer,\
    org.springframework.boot.web.context.ServerPortInfoApplicationContextInitializer
    ...
    ...
  ```

* classLoader.getResources的具体作用如下：

  ```java
      public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class);
        var classLoader = Application.class.getClassLoader();
        var urls =classLoader.getResources("META-INF/spring.factories");
        while(urls.hasMoreElements()){
          System.out.println(urls.nextElement());
        }
      }
        控制台输出：
      jar:file:/Users/user/.gradle/.../spring-boot-autoconfigure-2.3.0.RELEASE.jar!/META-INF/spring.factories
      jar:file:/Users/user/.gradle/.../spring-boot-2.3.0.RELEASE.jar!/META-INF/spring.factories
      jar:file:/Users/user/.gradle/.../spring-beans-5.2.6.RELEASE.jar!/META-INF/spring.factories
        ...
      ...
  ```

### 1.5 小结

应用初始化阶段主要进行了设置primarySources（一般来说就是我们的启动类）、设置Web应用类型（为Servelet应用、Reactive应用还是非Web应用等）、实例化ApplicationConext初始化器、实例化ApplicationListener监听器、设置mainApplicationClass等工作。

## 2. 应用程序启动

在完成应用初始化工作完成之后，就进入到应用程序启动阶段，我们顺着源码run方法可以进入到：

```java
    /**
     * Run the Spring application, creating and refreshing a new
     * {@link ApplicationContext}.
     * @param args the application arguments (usually passed from a Java main method)
     * @return a running {@link ApplicationContext}
     */
    public ConfigurableApplicationContext run(String... args) {
        // 一个简单的秒表计时器实现，主要功能就是计时
        StopWatch stopWatch = new StopWatch();
        // 启动计时器
        stopWatch.start();
        ConfigurableApplicationContext context = null;
        Collection<SpringBootExceptionReporter> exceptionReporters = new ArrayList<>();
        //Spring Boot 应用默认情况下运行在headless模式。意味着运行在没有图形界面GUI的服务器或者其他环境
        configureHeadlessProperty();
        // 获取RunListeners实例
        // 内部实现与上面getSpringFactoriesInstances类似，
        // 获取SpringApplicationRunListener的实例
        // 这里的SpringApplicationRunListener与上面我们提到的ApplicationListener不同
        // SpringApplicationRunListener 类是 SpringBoot 中新增的类
        // SpringApplication 类 中使用它们来间接调用åApplicationListener。
        // 另外还有一个新增的类是SpringApplicationRunListeners，
        // SpringApplicationRunListeners 中包含了多个 SpringApplicationRunListener
        SpringApplicationRunListeners listeners = getRunListeners(args);
        // 启动监听器
        listeners.starting();
        try {
            // 设置应用参数
            ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
            // 配置应用环境
            ConfigurableEnvironment environment = prepareEnvironment(listeners, applicationArguments);
            configureIgnoreBeanInfo(environment);
            // 打印Banner
            Banner printedBanner = printBanner(environment);
            // 创建ApplicationContext
            context = createApplicationContext();
            // 获取异常reporter实例
            exceptionReporters = getSpringFactoriesInstances(SpringBootExceptionReporter.class,
                    new Class[] { ConfigurableApplicationContext.class }, context);
            // 准备ApplicationContext，源码分析请参考2.2节
            prepareContext(context, environment, listeners, applicationArguments, printedBanner);
            refreshContext(context);
            afterRefresh(context, applicationArguments);
            stopWatch.stop();
            if (this.logStartupInfo) {
                new StartupInfoLogger(this.mainApplicationClass).logStarted(getApplicationLog(), stopWatch);
            }
            listeners.started(context);
            callRunners(context, applicationArguments);
        }
        catch (Throwable ex) {
            handleRunFailure(context, ex, exceptionReporters, listeners);
            throw new IllegalStateException(ex);
        }

        try {
            listeners.running(context);
        }
        catch (Throwable ex) {
            handleRunFailure(context, ex, exceptionReporters, null);
            throw new IllegalStateException(ex);
        }
        return context;
    }
```

### 2.1 创建ApplicationContext

```java
    /**
     * Strategy method used to create the {@link ApplicationContext}. By default this
     * method will respect any explicitly set application context or application context
     * class before falling back to a suitable default.
     * @return the application context (not yet refreshed)
     * @see #setApplicationContextClass(Class)
     */
    protected ConfigurableApplicationContext createApplicationContext() {
        Class<?> contextClass = this.applicationContextClass;
        if (contextClass == null) {
            try {
                switch (this.webApplicationType) {
                case SERVLET:
                       // AnnotationConfigServletWebServerApplicationContext
                    contextClass = Class.forName(DEFAULT_SERVLET_WEB_CONTEXT_CLASS);
                    break;
                case REACTIVE:
                      // AnnotationConfigReactiveWebServerApplicationContext
                    contextClass = Class.forName(DEFAULT_REACTIVE_WEB_CONTEXT_CLASS);
                    break;
                default:
                      // AnnotationConfigApplicationContext
                    contextClass = Class.forName(DEFAULT_CONTEXT_CLASS);
                }
            }
            catch (ClassNotFoundException ex) {
                throw new IllegalStateException(
                        "Unable create a default ApplicationContext, please specify an ApplicationContextClass", ex);
            }
        }
        return (ConfigurableApplicationContext) BeanUtils.instantiateClass(contextClass);
    }
```

### 2.2 prepareContext

```java
private void prepareContext(ConfigurableApplicationContext context, ConfigurableEnvironment environment,
            SpringApplicationRunListeners listeners, ApplicationArguments applicationArguments, Banner printedBanner) {
          // 设置环境
        context.setEnvironment(environment);
        postProcessApplicationContext(context);
        applyInitializers(context);
        listeners.contextPrepared(context);
        if (this.logStartupInfo) {
            logStartupInfo(context.getParent() == null);
            logStartupProfileInfo(context);
        }
        // Add boot specific singleton beans
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        beanFactory.registerSingleton("springApplicationArguments", applicationArguments);
        if (printedBanner != null) {
            beanFactory.registerSingleton("springBootBanner", printedBanner);
        }
         // 配置是否允许override bean definition
        if (beanFactory instanceof DefaultListableBeanFactory) {
            ((DefaultListableBeanFactory) beanFactory)
                    .setAllowBeanDefinitionOverriding(this.allowBeanDefinitionOverriding);
        }
          // lazy-init BeanFactoryPostProcessor
        if (this.lazyInitialization) {
            context.addBeanFactoryPostProcessor(new LazyInitializationBeanFactoryPostProcessor());
        }
        // Load the sources
        // 具体实现参考2.2.1节
        // 对于本文1.1节的应用demo，该处的source就是我们的启动类，类型为Class
        Set<Object> sources = getAllSources();
        Assert.notEmpty(sources, "Sources must not be empty");
          // 源码分析请参考2.2.2节
        load(context, sources.toArray(new Object[0]));
          // 广播发布ApplicationPreparedEvent
        listeners.contextLoaded(context);
    }
```

#### 2.2.1 getAllSources

```java
    /**
     * Return an immutable set of all the sources that will be added to an
     * ApplicationContext when {@link #run(String...)} is called. This method combines any
     * primary sources specified in the constructor with any additional ones that have
     * been {@link #setSources(Set) explicitly set}.
     * @return an immutable set of all sources
     */
    public Set<Object> getAllSources() {
        Set<Object> allSources = new LinkedHashSet<>();
        if (!CollectionUtils.isEmpty(this.primarySources)) {
            allSources.addAll(this.primarySources);
        }
        if (!CollectionUtils.isEmpty(this.sources)) {
            allSources.addAll(this.sources);
        }
        return Collections.unmodifiableSet(allSources);
    }
```

#### 2.2.2 load

```java
/**
     * Load beans into the application context.
     * @param context the context to load beans into
     * @param sources the sources to load
     */
    protected void load(ApplicationContext context, Object[] sources) {
        if (logger.isDebugEnabled()) {
            logger.debug("Loading source " + StringUtils.arrayToCommaDelimitedString(sources));
        }
        // 创建BeanDefinitionLoader，参考2.2.3节
        BeanDefinitionLoader loader = createBeanDefinitionLoader(getBeanDefinitionRegistry(context), sources);
        if (this.beanNameGenerator != null) {
            loader.setBeanNameGenerator(this.beanNameGenerator);
        }
        if (this.resourceLoader != null) {
            loader.setResourceLoader(this.resourceLoader);
        }
        if (this.environment != null) {
            loader.setEnvironment(this.environment);
        }
        loader.load();
    }

    int load() {
        int count = 0;
        for (Object source : this.sources) {
            count += load(source);
        }
        return count;
    }

    private int load(Object source) {
        Assert.notNull(source, "Source must not be null");
        if (source instanceof Class<?>) {
            return load((Class<?>) source);
        }
        if (source instanceof Resource) {
            return load((Resource) source);
        }
        if (source instanceof Package) {
            return load((Package) source);
        }
        if (source instanceof CharSequence) {
            return load((CharSequence) source);
        }
        throw new IllegalArgumentException("Invalid source type " + source.getClass());
    }
```

#### 2.2.3 createBeanDefinitionLoader

```java
    /**
     * Create a new {@link BeanDefinitionLoader} that will load beans into the specified
     * {@link BeanDefinitionRegistry}.
     * @param registry the bean definition registry that will contain the loaded beans
     * @param sources the bean sources
     */
    BeanDefinitionLoader(BeanDefinitionRegistry registry, Object... sources) {
        Assert.notNull(registry, "Registry must not be null");
        Assert.notEmpty(sources, "Sources must not be empty");
        this.sources = sources;
        this.annotatedReader = new AnnotatedBeanDefinitionReader(registry);
        this.xmlReader = new XmlBeanDefinitionReader(registry);
        if (isGroovyPresent()) {
            this.groovyReader = new GroovyBeanDefinitionReader(registry);
        }
        this.scanner = new ClassPathBeanDefinitionScanner(registry);
        this.scanner.addExcludeFilter(new ClassExcludeFilter(sources));
    }
```

### 2.3 🌟refreshContext

如果有看过spring源码的同学，那么一定知道Spring的大多数工作都在refresh这个方法中完成，在这里也是一样的。

```java
    private void refreshContext(ConfigurableApplicationContext context) {
        refresh((ApplicationContext) context);
        if (this.registerShutdownHook) {
            try {
                context.registerShutdownHook();
            }
            catch (AccessControlException ex) {
                // Not allowed in some environments.
            }
        }
    }

    /**
     * Refresh the underlying {@link ApplicationContext}.
     * @param applicationContext the application context to refresh
     * @deprecated since 2.3.0 in favor of
     * {@link #refresh(ConfigurableApplicationContext)}
     */
    @Deprecated
    protected void refresh(ApplicationContext applicationContext) {
        Assert.isInstanceOf(ConfigurableApplicationContext.class, applicationContext);
        refresh((ConfigurableApplicationContext) applicationContext);
    }

    /**
     * Refresh the underlying {@link ApplicationContext}.
     * @param applicationContext the application context to refresh
     */
    protected void refresh(ConfigurableApplicationContext applicationContext) {
        applicationContext.refresh();
    }
```

### 2.4 AbstractApplicationContext

```java
    @Override
    public void refresh() throws BeansException, IllegalStateException {
        synchronized (this.startupShutdownMonitor) {
            // Prepare this context for refreshing.
            prepareRefresh();

            // Tell the subclass to refresh the internal bean factory.
              // 这里的返回结果是DefaultListableBeanFactory
            ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

            // Prepare the bean factory for use in this context.
              // 准备DefaultListableBeanFactory
            prepareBeanFactory(beanFactory);

            try {
                // Allows post-processing of the bean factory in context subclasses.
                // 这个里面是一个空方法实现以供拓展
                postProcessBeanFactory(beanFactory);

                // Invoke factory processors registered as beans in the context.
                // 重点重点重点，包扫描、bean的解析等工作都在这一步完成
                // 请参考2.5节
                invokeBeanFactoryPostProcessors(beanFactory);

                // Register bean processors that intercept bean creation.
                registerBeanPostProcessors(beanFactory);

                // Initialize message source for this context.
                initMessageSource();

                // Initialize event multicaster for this context.
                initApplicationEventMulticaster();

                // Initialize other special beans in specific context subclasses.
                onRefresh();

                // Check for listener beans and register them.
                registerListeners();

                // Instantiate all remaining (non-lazy-init) singletons.
                // 重要重要重要实例化所有的非延迟初始化的Bean
                // 请参考2.6节
                finishBeanFactoryInitialization(beanFactory);

                // Last step: publish corresponding event.
                finishRefresh();
            }

            catch (BeansException ex) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Exception encountered during context initialization - " +
                            "cancelling refresh attempt: " + ex);
                }

                // Destroy already created singletons to avoid dangling resources.
                destroyBeans();

                // Reset 'active' flag.
                cancelRefresh(ex);

                // Propagate exception to caller.
                throw ex;
            }

            finally {
                // Reset common introspection caches in Spring's core, since we
                // might not ever need metadata for singleton beans anymore...
                resetCommonCaches();
            }
        }
    }
```

### 2.5 invokeBeanFactoryPostProcessors

```java
    /**
     * Instantiate and invoke all registered BeanFactoryPostProcessor beans,
     * respecting explicit order if given.
     * <p>Must be called before singleton instantiation.
     */
    protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        // 这里的getBeanFactoryPostProcessors会拿到所有的BeanFacotry后置处理器
        PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());

        // Detect a LoadTimeWeaver and prepare for weaving, if found in the meantime
        // (e.g. through an @Bean method registered by ConfigurationClassPostProcessor)
        if (beanFactory.getTempClassLoader() == null && beanFactory.containsBean(LOAD_TIME_WEAVER_BEAN_NAME)) {
            beanFactory.addBeanPostProcessor(new LoadTimeWeaverAwareProcessor(beanFactory));
            beanFactory.setTempClassLoader(new ContextTypeMatchClassLoader(beanFactory.getBeanClassLoader()));
        }
    }
```

* 在这里我们先补习一下**BeanFactoryPostProcessor**，由下面的接口定义可以知道通过bean工厂后置处理器我们还可以在`初始化`时进行一些额外的操作，由此来保证Spring的拓展性。

```java
public interface BeanFactoryPostProcessor {

    /**
     * Modify the application context's internal bean factory after its standard
     * initialization. All bean definitions will have been loaded, but no beans
     * will have been instantiated yet. This allows for overriding or adding
     * properties even to eager-initializing beans.
     * @param beanFactory the bean factory used by the application context
     * @throws org.springframework.beans.BeansException in case of errors
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
```

这一部分的代码比较复杂，但是其实做的事情还是比较简单，后续面的工作原理大致都是类似的，在这里我们只讲述几个关键步骤的分析：

1. 首先判断传入的beanFactory是不是BeanDefinitionRegistry的实例对象，由上文可知，我们这里的beanFactory是DefaultListableBeanFactory，它是一个BeanDefinitionRegistry的实例；
2. 创建两个List分别名为regularPostProcessors和registryProcessors，将BeanFactoryPostProcessor与BeanDefinitionRegistryPostProcessor分开；
3. 创建一个List名为currentRegistryProcessors，存放准备创建的BeanDefinitionRegistryPostProcessor；
4. 在beanFactory中获取所有BeanDefinitionRegistryPostProcessor类型的bean name，并且将新的BeanDefinitionRegistryPostProcessor添加到步骤二中的registryProcessors列表；

5. 我们看到了currentRegistryProcessors有一个ConfigurationClassPostProcessor类型的元素，好了这个就是我们设置Bean加载的重要实现了；

6. 在下面会通过invokeBeanDefinitionRegistryPostProcessors调用每一个BeanDefinitionRegistryPostProcessor的postProcessBeanDefinitionRegistry方法，其中ConfigurationClassPostProcessor的postProcessBeanDefinitionRegistry的源码分析请参考2.3.3节。

```java
// PostProcessorRegistrationDelegate.java
public static void invokeBeanFactoryPostProcessors(
            ConfigurableListableBeanFactory beanFactory, List<BeanFactoryPostProcessor> beanFactoryPostProcessors) {

        // Invoke BeanDefinitionRegistryPostProcessors first, if any.
        Set<String> processedBeans = new HashSet<>();
        // 判断传入的beanFactory是不是BeanDefinitionRegistry的实例对象
          // 由上文可知，我们这里的beanFactory是DefaultListableBeanFactory
          // DefaultListableBeanFactory是BeanDefinitionRegistry的实现类
        if (beanFactory instanceof BeanDefinitionRegistry) {
            BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
             // 这里创建两个List将BeanFactoryPostProcessor与BeanDefinitionRegistryPostProcessor分开
            List<BeanFactoryPostProcessor> regularPostProcessors = new ArrayList<>();
            List<BeanDefinitionRegistryPostProcessor> registryProcessors = new ArrayList<>();

            for (BeanFactoryPostProcessor postProcessor : beanFactoryPostProcessors) {
                if (postProcessor instanceof BeanDefinitionRegistryPostProcessor) {
                    BeanDefinitionRegistryPostProcessor registryProcessor =
                            (BeanDefinitionRegistryPostProcessor) postProcessor;
                    registryProcessor.postProcessBeanDefinitionRegistry(registry);
                    registryProcessors.add(registryProcessor);
                }
                else {
                    regularPostProcessors.add(postProcessor);
                }
            }

            // Do not initialize FactoryBeans here: We need to leave all regular beans
            // uninitialized to let the bean factory post-processors apply to them!
            // Separate between BeanDefinitionRegistryPostProcessors that implement
            // PriorityOrdered, Ordered, and the rest.
              // 创建一个List存放准备创建的BeanDefinitionRegistryPostProcessor
            List<BeanDefinitionRegistryPostProcessor> currentRegistryProcessors = new ArrayList<>();

            // First, invoke the BeanDefinitionRegistryPostProcessors that implement PriorityOrdered.
              // 在beanFactory中获取所有BeanDefinitionRegistryPostProcessor类型的bean name
            String[] postProcessorNames =
                    beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
            for (String ppName : postProcessorNames) {
                // 判断是否实现了PriorityOrdered了接口，
                // 之所以做这一步判断应该是为了下一步对BeanDefinitionRegistryPostProcessor进行排序
                if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
                    currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
                    processedBeans.add(ppName);
                }
            }
              // 对currentRegistryProcessors进行排序
            sortPostProcessors(currentRegistryProcessors, beanFactory);
              // 上面说到创建了两个list将BeanFactoryPostProcessor与BeanDefinitionRegistryPostProcessor分开
              // 将新的currentRegistryProcessors添加到上面的BeanDefinitionRegistryPostProcessor list
            registryProcessors.addAll(currentRegistryProcessors);
              // 进行BeanDefinition的加载
            invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
              // 清除新创建的currentRegistryProcessors
            currentRegistryProcessors.clear();

            // Next, invoke the BeanDefinitionRegistryPostProcessors that implement Ordered.
              // 与上面类似，调用实现了Ordered的BeanDefinitionRegistryPostProcessors
            postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
            for (String ppName : postProcessorNames) {
                if (!processedBeans.contains(ppName) && beanFactory.isTypeMatch(ppName, Ordered.class)) {
                    currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
                    processedBeans.add(ppName);
                }
            }
            sortPostProcessors(currentRegistryProcessors, beanFactory);
            registryProcessors.addAll(currentRegistryProcessors);
            invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
            currentRegistryProcessors.clear();

            // Finally, invoke all other BeanDefinitionRegistryPostProcessors until no further ones appear.
              // 与上面类似，调用全部的其他BeanDefinitionRegistryPostProcessors
            boolean reiterate = true;
            while (reiterate) {
                reiterate = false;
                postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
                for (String ppName : postProcessorNames) {
                    if (!processedBeans.contains(ppName)) {
                        currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
                        processedBeans.add(ppName);
                        reiterate = true;
                    }
                }
                sortPostProcessors(currentRegistryProcessors, beanFactory);
                registryProcessors.addAll(currentRegistryProcessors);
                invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
                currentRegistryProcessors.clear();
            }

            // Now, invoke the postProcessBeanFactory callback of all processors handled so far.
            invokeBeanFactoryPostProcessors(registryProcessors, beanFactory);
            invokeBeanFactoryPostProcessors(regularPostProcessors, beanFactory);
        }

        else {
            // Invoke factory processors registered with the context instance.
            invokeBeanFactoryPostProcessors(beanFactoryPostProcessors, beanFactory);
        }

        // Do not initialize FactoryBeans here: We need to leave all regular beans
        // uninitialized to let the bean factory post-processors apply to them!
        String[] postProcessorNames =
                beanFactory.getBeanNamesForType(BeanFactoryPostProcessor.class, true, false);

        // Separate between BeanFactoryPostProcessors that implement PriorityOrdered,
        // Ordered, and the rest.
        List<BeanFactoryPostProcessor> priorityOrderedPostProcessors = new ArrayList<>();
        List<String> orderedPostProcessorNames = new ArrayList<>();
        List<String> nonOrderedPostProcessorNames = new ArrayList<>();
        for (String ppName : postProcessorNames) {
            if (processedBeans.contains(ppName)) {
                // skip - already processed in first phase above
            }
            else if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
                priorityOrderedPostProcessors.add(beanFactory.getBean(ppName, BeanFactoryPostProcessor.class));
            }
            else if (beanFactory.isTypeMatch(ppName, Ordered.class)) {
                orderedPostProcessorNames.add(ppName);
            }
            else {
                nonOrderedPostProcessorNames.add(ppName);
            }
        }

        // First, invoke the BeanFactoryPostProcessors that implement PriorityOrdered.
        sortPostProcessors(priorityOrderedPostProcessors, beanFactory);
        invokeBeanFactoryPostProcessors(priorityOrderedPostProcessors, beanFactory);

        // Next, invoke the BeanFactoryPostProcessors that implement Ordered.
        List<BeanFactoryPostProcessor> orderedPostProcessors = new ArrayList<>(orderedPostProcessorNames.size());
        for (String postProcessorName : orderedPostProcessorNames) {
            orderedPostProcessors.add(beanFactory.getBean(postProcessorName, BeanFactoryPostProcessor.class));
        }
        sortPostProcessors(orderedPostProcessors, beanFactory);
        invokeBeanFactoryPostProcessors(orderedPostProcessors, beanFactory);

        // Finally, invoke all other BeanFactoryPostProcessors.
        List<BeanFactoryPostProcessor> nonOrderedPostProcessors = new ArrayList<>(nonOrderedPostProcessorNames.size());
        for (String postProcessorName : nonOrderedPostProcessorNames) {
            nonOrderedPostProcessors.add(beanFactory.getBean(postProcessorName, BeanFactoryPostProcessor.class));
        }
        invokeBeanFactoryPostProcessors(nonOrderedPostProcessors, beanFactory);

        // Clear cached merged bean definitions since the post-processors might have
        // modified the original metadata, e.g. replacing placeholders in values...
        beanFactory.clearMetadataCache();
    }
```

#### 2.5.1 ConfigurationClassPostProcessor

ConfigurationClassPostProcessor对于BeanDefinitionRegistryPostProcessor接口的实现

```java
    /**
     * Derive further bean definitions from the configuration classes in the registry.
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
        int registryId = System.identityHashCode(registry);
        if (this.registriesPostProcessed.contains(registryId)) {
            throw new IllegalStateException(
                    "postProcessBeanDefinitionRegistry already called on this post-processor against " + registry);
        }
        if (this.factoriesPostProcessed.contains(registryId)) {
            throw new IllegalStateException(
                    "postProcessBeanFactory already called on this post-processor against " + registry);
        }
        this.registriesPostProcessed.add(registryId);

        processConfigBeanDefinitions(registry);
    }
```

processConfigBeanDefinitions中主要做了以下几件事情：

1. 获取IOC容器中的所有BeanDefinition的名称，遍历所有的BeanDefinition名称，筛选出所有的配置类；
2. 对配置类列表configCandidates进行排序；
3. 创建一个配置类解析器ConfigurationClassParser，进行配置类的解析；
4. 具体解析函数的实现请参考[2.5.2 解析配置类](springboot_boot_process.md#2.5.2%20解析配置类)

```java
/**
 * Build and validate a configuration model based on the registry of
 * {@link Configuration} classes.
 */
public void processConfigBeanDefinitions(BeanDefinitionRegistry registry) {
      // 保存配置类的BeanDefinitionHolder
    List<BeanDefinitionHolder> configCandidates = new ArrayList<>();

    String[] candidateNames = registry.getBeanDefinitionNames();
    // 获取IOC容器中的所有BeanDefinition的名称，筛选出配置类
    for (String beanName : candidateNames) {
        BeanDefinition beanDef = registry.getBeanDefinition(beanName);
        if (beanDef.getAttribute(ConfigurationClassUtils.CONFIGURATION_CLASS_ATTRIBUTE) != null) {
            if (logger.isDebugEnabled()) {
                logger.debug("Bean definition has already been processed as a configuration class: " + beanDef);
            }
        }
        else if (ConfigurationClassUtils.checkConfigurationClassCandidate(beanDef, this.metadataReaderFactory)) {
            configCandidates.add(new BeanDefinitionHolder(beanDef, beanName));
        }
    }

    // Return immediately if no @Configuration classes were found
    if (configCandidates.isEmpty()) {
        return;
    }

    // Sort by previously determined @Order value, if applicable
      // 对配置类进行排序
    configCandidates.sort((bd1, bd2) -> {
        int i1 = ConfigurationClassUtils.getOrder(bd1.getBeanDefinition());
        int i2 = ConfigurationClassUtils.getOrder(bd2.getBeanDefinition());
        return Integer.compare(i1, i2);
    });

    // Detect any custom bean name generation strategy supplied through the enclosing application context
    SingletonBeanRegistry sbr = null;
    if (registry instanceof SingletonBeanRegistry) {
        sbr = (SingletonBeanRegistry) registry;
        if (!this.localBeanNameGeneratorSet) {
            BeanNameGenerator generator = (BeanNameGenerator) sbr.getSingleton(
                    AnnotationConfigUtils.CONFIGURATION_BEAN_NAME_GENERATOR);
            if (generator != null) {
                this.componentScanBeanNameGenerator = generator;
                this.importBeanNameGenerator = generator;
            }
        }
    }

    if (this.environment == null) {
        this.environment = new StandardEnvironment();
    }

    // Parse each @Configuration class
      // 创建一个配置类解析器
    ConfigurationClassParser parser = new ConfigurationClassParser(
            this.metadataReaderFactory, this.problemReporter, this.environment,
            this.resourceLoader, this.componentScanBeanNameGenerator, registry);

      // 创建一个set candidates，长度为配置类的长度，元素为配置类.
      // 创建一个set保存已经解析过的配置类，长度也为配置类的长度
    Set<BeanDefinitionHolder> candidates = new LinkedHashSet<>(configCandidates);
    Set<ConfigurationClass> alreadyParsed = new HashSet<>(configCandidates.size());
      // 解析配置类机制 直到candidates.isEmpty()
    do {
        // 解析函数
        parser.parse(candidates);
        parser.validate();

        Set<ConfigurationClass> configClasses = new LinkedHashSet<>(parser.getConfigurationClasses());
        configClasses.removeAll(alreadyParsed);

        // Read the model and create bean definitions based on its content
        if (this.reader == null) {
            this.reader = new ConfigurationClassBeanDefinitionReader(
                    registry, this.sourceExtractor, this.resourceLoader, this.environment,
                    this.importBeanNameGenerator, parser.getImportRegistry());
        }
        this.reader.loadBeanDefinitions(configClasses);
        alreadyParsed.addAll(configClasses);

        candidates.clear();
        if (registry.getBeanDefinitionCount() > candidateNames.length) {
            String[] newCandidateNames = registry.getBeanDefinitionNames();
            Set<String> oldCandidateNames = new HashSet<>(Arrays.asList(candidateNames));
            Set<String> alreadyParsedClasses = new HashSet<>();
            for (ConfigurationClass configurationClass : alreadyParsed) {
                alreadyParsedClasses.add(configurationClass.getMetadata().getClassName());
            }
            for (String candidateName : newCandidateNames) {
                if (!oldCandidateNames.contains(candidateName)) {
                    BeanDefinition bd = registry.getBeanDefinition(candidateName);
                    if (ConfigurationClassUtils.checkConfigurationClassCandidate(bd, this.metadataReaderFactory)                             &&!alreadyParsedClasses.contains(bd.getBeanClassName())) {
                        candidates.add(new BeanDefinitionHolder(bd, candidateName));
                    }
                }
            }
            candidateNames = newCandidateNames;
        }
    }
    while (!candidates.isEmpty());

    // Register the ImportRegistry as a bean in order to support ImportAware @Configuration classes
    if (sbr != null && !sbr.containsSingleton(IMPORT_REGISTRY_BEAN_NAME)) {
        sbr.registerSingleton(IMPORT_REGISTRY_BEAN_NAME, parser.getImportRegistry());
    }

    if (this.metadataReaderFactory instanceof CachingMetadataReaderFactory) {
        // Clear cache in externally provided MetadataReaderFactory; this is a no-op
        // for a shared cache since it'll be cleared by the ApplicationContext.
        ((CachingMetadataReaderFactory) this.metadataReaderFactory).clearCache();
    }
}
```

#### 2.5.2 解析配置类

```java
public void parse(Set<BeanDefinitionHolder> configCandidates) {
        for (BeanDefinitionHolder holder : configCandidates) {
            BeanDefinition bd = holder.getBeanDefinition();
            try {
                if (bd instanceof AnnotatedBeanDefinition) {
                    parse(((AnnotatedBeanDefinition) bd).getMetadata(), holder.getBeanName());
                }
                else if (bd instanceof AbstractBeanDefinition && ((AbstractBeanDefinition) bd).hasBeanClass()) {
                    parse(((AbstractBeanDefinition) bd).getBeanClass(), holder.getBeanName());
                }
                else {
                    parse(bd.getBeanClassName(), holder.getBeanName());
                }
            }
            catch (BeanDefinitionStoreException ex) {
                throw ex;
            }
            catch (Throwable ex) {
                throw new BeanDefinitionStoreException(
                        "Failed to parse configuration class [" + bd.getBeanClassName() + "]", ex);
            }
        }

        this.deferredImportSelectorHandler.process();
    }
```

* parse\(bd.getBeanClassName\(\), holder.getBeanName\(\)\)

```java
protected void processConfigurationClass(ConfigurationClass configClass, Predicate<String> filter) throws IOException {
 if (this.conditionEvaluator.shouldSkip(configClass.getMetadata(), ConfigurationPhase.PARSE_CONFIGURATION)) {
  return;
 }

 ConfigurationClass existingClass = this.configurationClasses.get(configClass);
 if (existingClass != null) {
  if (configClass.isImported()) {
   if (existingClass.isImported()) {
    existingClass.mergeImportedBy(configClass);
   }
   // Otherwise ignore new imported config class; existing non-imported class overrides it.
   return;
  }
  else {
   // Explicit bean definition found, probably replacing an import.
   // Let's remove the old one and go with the new one.
   this.configurationClasses.remove(configClass);
   this.knownSuperclasses.values().removeIf(configClass::equals);
  }
 }

 // Recursively process the configuration class and its superclass hierarchy.
 SourceClass sourceClass = asSourceClass(configClass, filter);
 do {
  sourceClass = doProcessConfigurationClass(configClass, sourceClass, filter);
 }
 while (sourceClass != null);

 this.configurationClasses.put(configClass, configClass);
}
```

* doProcessConfigurationClass 1. @Component 2. @PropertySource 3. @ComponentScan 4. @Import 5. @ImportResource 6. @Bean

  上述注解的解析全是在这里完成解析的

```java
    /**
     * Apply processing and build a complete {@link ConfigurationClass} by reading the
     * annotations, members and methods from the source class. This method can be called
     * multiple times as relevant sources are discovered.
     * @param configClass the configuration class being build
     * @param sourceClass a source class
     * @return the superclass, or {@code null} if none found or previously processed
     */
    @Nullable
    protected final SourceClass doProcessConfigurationClass(
            ConfigurationClass configClass, SourceClass sourceClass, Predicate<String> filter)
            throws IOException {
        // 处理Component注解类
        if (configClass.getMetadata().isAnnotated(Component.class.getName())) {
            // Recursively process any member (nested) classes first
            processMemberClasses(configClass, sourceClass, filter);
        }

        // Process any @PropertySource annotations
        for (AnnotationAttributes propertySource : AnnotationConfigUtils.attributesForRepeatable(
                sourceClass.getMetadata(), PropertySources.class,
                org.springframework.context.annotation.PropertySource.class)) {
            if (this.environment instanceof ConfigurableEnvironment) {
                processPropertySource(propertySource);
            }
            else {
                logger.info("Ignoring @PropertySource annotation on [" + sourceClass.getMetadata().getClassName() +
                        "]. Reason: Environment must implement ConfigurableEnvironment");
            }
        }

        // Process any @ComponentScan annotations
        Set<AnnotationAttributes> componentScans = AnnotationConfigUtils.attributesForRepeatable(
                sourceClass.getMetadata(), ComponentScans.class, ComponentScan.class);
        if (!componentScans.isEmpty() &&
                !this.conditionEvaluator.shouldSkip(sourceClass.getMetadata(), ConfigurationPhase.REGISTER_BEAN)) {
            for (AnnotationAttributes componentScan : componentScans) {
                // The config class is annotated with @ComponentScan -> perform the scan immediately
                Set<BeanDefinitionHolder> scannedBeanDefinitions =
                        this.componentScanParser.parse(componentScan, sourceClass.getMetadata().getClassName());
                // Check the set of scanned definitions for any further config classes and parse recursively if needed
                for (BeanDefinitionHolder holder : scannedBeanDefinitions) {
                    BeanDefinition bdCand = holder.getBeanDefinition().getOriginatingBeanDefinition();
                    if (bdCand == null) {
                        bdCand = holder.getBeanDefinition();
                    }
                    if (ConfigurationClassUtils.checkConfigurationClassCandidate(bdCand, this.metadataReaderFactory)) {
                        parse(bdCand.getBeanClassName(), holder.getBeanName());
                    }
                }
            }
        }

        // Process any @Import annotations
        processImports(configClass, sourceClass, getImports(sourceClass), filter, true);

        // Process any @ImportResource annotations
        AnnotationAttributes importResource =
                AnnotationConfigUtils.attributesFor(sourceClass.getMetadata(), ImportResource.class);
        if (importResource != null) {
            String[] resources = importResource.getStringArray("locations");
            Class<? extends BeanDefinitionReader> readerClass = importResource.getClass("reader");
            for (String resource : resources) {
                String resolvedResource = this.environment.resolveRequiredPlaceholders(resource);
                configClass.addImportedResource(resolvedResource, readerClass);
            }
        }

        // Process individual @Bean methods
        Set<MethodMetadata> beanMethods = retrieveBeanMethodMetadata(sourceClass);
        for (MethodMetadata methodMetadata : beanMethods) {
            configClass.addBeanMethod(new BeanMethod(methodMetadata, configClass));
        }

        // Process default methods on interfaces
        processInterfaces(configClass, sourceClass);

        // Process superclass, if any
        if (sourceClass.getMetadata().hasSuperClass()) {
            String superclass = sourceClass.getMetadata().getSuperClassName();
            if (superclass != null && !superclass.startsWith("java") &&
                    !this.knownSuperclasses.containsKey(superclass)) {
                this.knownSuperclasses.put(superclass, configClass);
                // Superclass found, return its annotation metadata and recurse
                return sourceClass.getSuperClass();
            }
        }

        // No superclass -> processing is complete
        return null;
    }
```

### 2.6 finishBeanFactoryInitialization

