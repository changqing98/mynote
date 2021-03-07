#include <zconf.h>
#include <sys/wait.h>
#include "stdio.h"

int main(){
    int status;
    printf("Ready to create child process...: %d\n", getpid());
    int p = fork();
    if(p == 0){
        printf("this is child process: %d\n", getpid());
        sleep(2);
        _exit(0);
    } else if (p > 0) {
        printf("this is parent process: %d\n", getpid());
        printf("Process over: %d\n", getpid());
        int pid = wait(NULL);
        printf("Pid: %d", pid);
    }
}
