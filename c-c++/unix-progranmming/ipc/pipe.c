#include <stdio.h>
#include <unistd.h>
#include "sched.h"

int main() {
    int fd[2];
    if (pipe(fd) < 0) {
        printf("Create pipe error");
    }
    sched_setparam()
}

