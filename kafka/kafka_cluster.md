---
description: 本文主要介绍采用 Docker Compose 的方式搭建 Kafka 集群，仅供开发测试使用。
---

# Kafka集群搭建

## Docker-compose搭建单机伪集群

### 1. docker创建network

```bash
docker network create --driver bridge --subnet 172.23.0.0/25 --gateway 172.23.0.1  zookeeper_network
```

### 2. 准备构建

#### 在当前目录创建好zoo.cfg文件

```text
# The number of milliseconds of each tick
tickTime=2000
# The number of ticks that the initial
# synchronization phase can take
initLimit=10
# The number of ticks that can pass between
# sending a request and getting an acknowledgement
syncLimit=5
# the directory where the snapshot is stored.
# do not use /tmp for storage, /tmp here is just
# example sakes.
dataDir=/data
dataLogDir=/datalog
# the port at which the clients will connect
clientPort=2181
# the maximum number of client connections.
# increase this if you need to handle more clients
#maxClientCnxns=60
#
# Be sure to read the maintenance section of the
# administrator guide before turning on autopurge.
#
# http://zookeeper.apache.org/doc/current/zookeeperAdmin.html#sc_maintenance
#
# The number of snapshots to retain in dataDir
autopurge.snapRetainCount=3
# Purge task interval in hours
# Set to "0" to disable auto purge feature
autopurge.purgeInterval=1
server.1= zoo1:2888:3888
server.2= zoo2:2888:3888
server.3= zoo3:2888:3888
```

#### 分别创建zookeeper1，zookeeper2，zookeeper3 ,如果没有特殊配置需要，将上面的zoo.cfg文件分别拷贝至3个文件夹下。

```bash
mkdir zookeeper1 zookeeper2 zookeeper3
cp zoo.cfg zookeeper1/
cp zoo.cfg zookeeper2/
cp zoo.cfg zookeeper3/
```

#### docker-compose.yaml

```yaml
version: '2'

services:
  zoo1:
    image: zookeeper # 镜像
    restart: always # 重启
    container_name: zoo1
    hostname: zoo1
    ports:
      - "2181:2181"
    volumes:
      - "./zookeeper1/zoo.cfg:/conf/zoo.cfg" # 配置文件，参考下面给出的zoo.cfg配置
      - "./zookeeper1/data:/data"
      - "./zookeeper1/datalog:/datalog"
    environment:
      ZOO_MY_ID: 1 # id
      ZOO_SERVERS: server.1=zoo1:2888:3888 server.2=zoo2:2888:3888 server.3=zoo3:2888:3888
    networks:
      default:
        ipv4_address: 172.23.0.11

  zoo2:
    image: zookeeper
    restart: always
    container_name: zoo2
    hostname: zoo2
    ports:
      - "2182:2181"
    volumes:
      - "./zookeeper2/zoo.cfg:/conf/zoo.cfg" # 配置文件，参考下面给出的zoo.cfg配置
      - "./zookeeper2/data:/data"
      - "./zookeeper2/datalog:/datalog"
    environment:
      ZOO_MY_ID: 2
      ZOO_SERVERS: server.1=zoo1:2888:3888 server.2=zoo2:2888:3888 server.3=zoo3:2888:3888
    networks:
      default:
        ipv4_address: 172.23.0.12

  zoo3:
    image: zookeeper
    restart: always
    container_name: zoo3
    hostname: zoo3
    ports:
      - "2183:2181"
    volumes:
      - "./zookeeper3/zoo.cfg:/conf/zoo.cfg" # 配置文件，参考下面给出的zoo.cfg配置
      - "./zookeeper4/data:/data"
      - "./zookeeper3/datalog:/datalog"
    environment:
      ZOO_MY_ID: 3
      ZOO_SERVERS: server.1=zoo1:2888:3888 server.2=zoo2:2888:3888 server.3=zoo3:2888:3888
    networks:
      default:
        ipv4_address: 172.23.0.13

  kafka1:
    image: wurstmeister/kafka # 镜像
    restart: always
    container_name: kafka1
    hostname: kafka1
    ports:
      - 9092:9092
      - 9999:9999
    environment:
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://139.224.233.110:9092 # 暴露在外的地址
      KAFKA_ADVERTISED_HOST_NAME: kafka1 #
      KAFKA_HOST_NAME: kafka1
      KAFKA_ZOOKEEPER_CONNECT: zoo1:2181,zoo2:2181,zoo3:2181
      KAFKA_ADVERTISED_PORT: 9092 # 暴露在外的端口
      KAFKA_BROKER_ID: 0 #
      KAFKA_LISTENERS: PLAINTEXT://0.0.0.0:9092
      JMX_PORT: 9999 # jmx
      KAFKA_HEAP_OPTS: "-Xmx256M -Xms256M"
    volumes:
      - /etc/localtime:/etc/localtime
      - "/disk/docker/kafka1/logs:/kafka"
    links:
      - zoo1
      - zoo2
      - zoo3
    networks:
      default:
        ipv4_address: 172.23.0.14

  kafka2:
    image: wurstmeister/kafka
    restart: always
    container_name: kafka2
    hostname: kafka2
    ports:
      - 9093:9092
      - 9998:9999
    environment:
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://139.224.233.110:9093
      KAFKA_ADVERTISED_HOST_NAME: kafka2
      KAFKA_HOST_NAME: kafka2
      KAFKA_ZOOKEEPER_CONNECT: zoo1:2181,zoo2:2181,zoo3:2181
      KAFKA_ADVERTISED_PORT: 9093
      KAFKA_BROKER_ID: 1
      KAFKA_LISTENERS: PLAINTEXT://0.0.0.0:9092
      JMX_PORT: 9999
      KAFKA_HEAP_OPTS: "-Xmx256M -Xms256M"
    volumes:
      - /etc/localtime:/etc/localtime
      - "/disk/docker/kafka2/logs:/kafka"
    links:
      - zoo1
      - zoo2
      - zoo3
    networks:
      default:
        ipv4_address: 172.23.0.15

  kafka3:
    image: wurstmeister/kafka
    restart: always
    container_name: kafka3
    hostname: kafka3
    ports:
      - 9094:9092
      - 9997:9999
    environment:
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://139.224.233.110:9094
      KAFKA_ADVERTISED_HOST_NAME: kafka3
      KAFKA_HOST_NAME: kafka3
      KAFKA_ZOOKEEPER_CONNECT: zoo1:2181,zoo2:2181,zoo3:2181
      KAFKA_ADVERTISED_PORT: 9094
      KAFKA_BROKER_ID: 2
      KAFKA_LISTENERS: PLAINTEXT://0.0.0.0:9092
      JMX_PORT: 9999
      KAFKA_HEAP_OPTS: -Xmx256M -Xms256M
    volumes:
      - /etc/localtime:/etc/localtime
      - "/disk/docker/kafka3/logs:/kafka"
    links:
      - zoo1
      - zoo2
      - zoo3
    networks:
      default:
        ipv4_address: 172.23.0.16
  # kafka4: # 主要用作模拟broker的新增与退出
  #   image: wurstmeister/kafka
  #   restart: always
  #   container_name: kafka4
  #   hostname: kafka4
  #   ports:
  #     - 9095:9092
  #     - 9996:9999
  #   environment:
  #     KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://139.224.233.110:9095
  #     KAFKA_ADVERTISED_HOST_NAME: kafka4
  #     KAFKA_HOST_NAME: kafka4
  #     KAFKA_ZOOKEEPER_CONNECT: zoo1:2181,zoo2:2181,zoo3:2181
  #     KAFKA_ADVERTISED_PORT: 9095
  #     KAFKA_BROKER_ID: 4
  #     KAFKA_LISTENERS: PLAINTEXT://0.0.0.0:9092
  #     JMX_PORT: 9999
  #     KAFKA_HEAP_OPTS: -Xmx256M -Xms256M
  #   volumes:
  #     - /etc/localtime:/etc/localtime
  #     - "/disk/docker/kafka3/logs:/kafka"
  #   links:
  #     - zoo1
  #     - zoo2
  #     - zoo3
  #   networks:
  #     default:
  #       ipv4_address: 172.23.0.17
  kafka-manager:
    image: hlebalbau/kafka-manager
    restart: always
    container_name: kafka-manager
    hostname: kafka-manager
    ports:
      - 9000:9000
    links:
      - kafka1
      - kafka2
      - kafka3
      - kafka4
      - zoo1
      - zoo2
      - zoo3
    environment:
      ZK_HOSTS: zoo1:2181,zoo2:2181,zoo3:2181
      KAFKA_BROKERS: kafka1:9092,kafka2:9093,kafka3:9094,kafka4:9095
      APPLICATION_SECRET: letmein
      KAFKA_MANAGER_AUTH_ENABLED: "true" # 开启验证
      KAFKA_MANAGER_USERNAME: "admin" # 用户名
      KAFKA_MANAGER_PASSWORD: "admin" # 密码
      KM_ARGS: -Djava.net.preferIPv4Stack=true
    networks:
      default:
        ipv4_address: 172.23.0.10

networks:
  default:
    external:
      name: zookeeper_network
```

#### 执行构建命令

```bash
docker-compose up -d
```

#### 登录kafka-manager管理界面查看集群信息[http://localhost:9000/](http://yechangqing.com:9000/) 初始用户名密码均为admin。 



