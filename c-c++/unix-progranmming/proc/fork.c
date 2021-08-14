#include "stdio.h"
#include "unistd.h"

int main() {
    int pid = fork();
    if (pid == 0) {
        printf(("this is child process\n"));
    } else if (pid > 0) {
        printf("this is parent process, child pid: %d\n", pid);
    } else {
        printf("error: %d\n", pid);
    }
}