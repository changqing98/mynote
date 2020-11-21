package com.yechangqing.demo.java.springboot.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WebFilter extends HttpFilter implements InitializingBean {

  @Value("#{'${web.security.excludeUrlPatterns:/metrics}'}")
  private List<String> excludeUrlPatterns;

  private List<Pattern> patterns = new ArrayList<>();

  @Value("${web.security.authorization:YWRtaW46YWRtaW4=}")
  private String authorization;

  @Override
  public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    var uri = request.getRequestURI();
    if (!excludeUrlMatch(uri)) {
      var reqAuthorization = request.getHeader("Authorization");
      if (reqAuthorization == null || !check(reqAuthorization)) {
        response.setStatus(401);
        response.setHeader("WWW-authenticate", "Basic");
        return;
      }
    }
    chain.doFilter(request, response);
  }

  /**
   * 校验是否是不需要过滤的url
   */
  private boolean excludeUrlMatch(String uri) {
    for (Pattern x : patterns) {
      if (x.matcher(uri).matches()) {
        return true;
      }
    }
    return false;
  }

  /**
   * 校验authorization
   */
  private boolean check(String reqAuthorization) {
    if (authorization.equals(reqAuthorization.substring(6))) {
      return true;
    }
    return false;
  }

  @Override
  public void afterPropertiesSet() {
    if (excludeUrlPatterns != null) {
      for (String p : excludeUrlPatterns) {
        patterns.add(Pattern.compile(p));
      }
    }
  }

  public static void main(String[] args) {

    System.out.println("1231".substring(4));
  }
}
