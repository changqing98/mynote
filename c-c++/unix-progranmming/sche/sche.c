#include "stdio.h"
#include "unistd.h"

int main() {
    while (1) {
        int p = nice(0);
        printf("Prio: %d", p);
        sleep(1);
    }
}