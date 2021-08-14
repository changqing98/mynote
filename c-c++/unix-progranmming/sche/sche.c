#include "stdio.h"
#include "unistd.h"

int main() {
    int p = nice(0);
    printf("Priority: %d", p);
    sleep(1);
}