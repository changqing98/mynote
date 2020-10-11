# 计算机网络

## TCP 连接建立与释放

#### TCP 建立连接 3 次握手

```sequence
client -> server: SYN, seq = x
note left of client: 客户端发送SYN确认比特，\nx为随机产生的一个值，\n进入SYN_SEND状态
note right of server: 服务端收到SYN后响应SYN + ACK，\n进入SYN_RECV状态
server -> client: SYN+ACK,ack=x+1,seq=y
note left of client: 客户端收到SYN+ACK后向服务端发送一个ACK,\n进入ESTABLISHED状态
client -> server: ACK,seq=x+1,ack=y+1
note right of server: 服务端收到客户端的ACK后进入ESTABLISHED状态


```

## 