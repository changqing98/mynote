#include "stdio.h"
#include "unistd.h"

int main() {
    printf("Ready to create child process, current process pid: %d\n", getpid());
    int p = fork();
    if (p == 0) {
        printf(("this is child process\n"));
    } else if (p > 0) {
        printf("this is parent process, child pid: %d\n", getpid());
    }
}