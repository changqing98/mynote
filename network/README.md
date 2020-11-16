# 计算机网络

## 一、 传输层

### 1.1 TCP 

#### 1.1.1 TCP 建立连接 3 次握手

```sequence
client -> server: SYN, seq = x
note left of client: 客户端发送SYN确认比特，\nx为随机产生的一个值，\n进入SYN_SEND状态
note right of server: 服务端收到SYN后响应SYN + ACK，\n进入SYN_RECV状态
server -> client: SYN+ACK,ack=x+1,seq=y
note left of client: 客户端收到SYN+ACK后向服务端发送一个ACK,\n进入ESTABLISHED状态
client -> server: ACK,seq=x+1,ack=y+1
note right of server: 服务端收到客户端的ACK后进入ESTABLISHED状态


```

### 1.1.2 TCP连接释放

### 1.1.3 流量控制

流量控制主要是为了解决通信双方的数据发送与数据接收的速率不匹配的问题。

TCP数据段是以字节为单位进行编号的，是以TCP数据段为单位进行传输的，每一个TCP数据段都有一个TCP头，接口方可以通过TCP头识别接受到的数据属于那个数据段。

TCP实现流量控制是采用滑动窗口协议，即在TCP通信双方分别维护了一个发送窗口和接收矿口，其窗口大小又分为物理窗口大小与可用窗口大小。



