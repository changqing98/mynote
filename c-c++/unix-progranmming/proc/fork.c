#include "stdio.h"
#include "unistd.h"

int main() {
    int p = fork();
    if (p == 0) {
        printf(("this is child process\n"));
    } else if (p > 0) {
        printf("this is parent process, child pid: %d\n", getpid());
    }
}