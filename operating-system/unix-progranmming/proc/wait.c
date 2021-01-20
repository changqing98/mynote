#include <zconf.h>
#include "stdio.h"

int main(){
    int pid = getpid();
    printf("%d", pid);
    return 0;
}
