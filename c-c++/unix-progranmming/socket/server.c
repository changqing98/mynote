#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <netinet/in.h>

int main(){
    //创建套接字
    int serv_sock = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
    //将套接字和IP、端口绑定
    struct sockaddr_in server_address;
    memset(&server_address, 0, sizeof(server_address));  //每个字节都用0填充
    server_address.sin_family = AF_INET;  //使用IPv4地址
    server_address.sin_addr.s_addr = inet_addr("127.0.0.1");  //具体的IP地址
    server_address.sin_port = htons(1234);  //端口
    bind(serv_sock, (struct sockaddr*)&server_address, sizeof(server_address));
    //进入监听状态，等待用户发起请求
    listen(serv_sock, 20);
    //接收客户端请求
    struct sockaddr_in client_address;
    socklen_t client_address_size = sizeof(client_address);
    for(;;){
        int client_socket_fd = accept(serv_sock, (struct sockaddr*)&client_address, &client_address_size);
        //向客户端发送数据
        char str[] = "Welcome!";
        write(client_socket_fd, str, sizeof(str));
        //关闭套接字
        close(client_socket_fd);
    }
    close(serv_sock);
    return 0;
}