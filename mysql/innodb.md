# InnoDB

InnoDB存储引擎支持事务，行级锁、支持外键、非锁定读（默认读操作不会加锁），是MySQL5.5.8之后的默认存储引擎。

通过MVCC（多版本并发控制）来获得高并发性、实现了SQL标准的4种隔离级别，默认为REPEATABLE级别，使用next-key locking的策略来避免幻读（phantom）。

InnoDB提供了插入缓存（insert buffer）、二次写（double-write）、自适应哈希索引（adaptive hash index）、预读取（read ahead）等高性能、高可用的功能。

## InnoDB体系结构

### 线程模型

InnoDB存储引擎是多线程模型，不同的后台线程负责处理不同的任务。

1. Master Thread

非常核心的后台线程

* 负责将缓冲池中的数据异步刷新到磁盘
* 保证数据一致性
* 合并插入缓冲
* 脏页的刷新
* UNDO页的回收
* IO Thread

InnoDB中使用了大量的AIO来处理写IO

### InnoDB关键特性

* 插入缓冲
* 两次写
* 自适应Hash索引
* 异步IO
* 刷新领接页

