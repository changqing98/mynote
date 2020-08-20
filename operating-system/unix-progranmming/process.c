//
// Created by changqing on 2020/8/20.
//
#include <stdio.h>
#include <stdlib.h>
#include <sys/_types/_pid_t.h>
#include <sys/types.h>
#include <unistd.h>

extern int create_process (char* program, char** arg_list);

int create_process (char* program, char** arg_list) {
  pid_t child_pid;
  child_pid = fork();
  if (child_pid != 0) {
    return child_pid;
  } else {
    execvp(program,  arg_list);
    abort();
  }
}
