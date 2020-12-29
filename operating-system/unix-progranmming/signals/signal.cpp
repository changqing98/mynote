//
// Created by changqing on 2020/12/29.
//

static void sig_user(int);

#include "signal.h"
int main() {
    if (signal(SIGUSR1, sig_user) == SIG_ERR){

    }
}
