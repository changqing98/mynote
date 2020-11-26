#include <unistd.h>
#include <stdio.h>

int main(){
  int pid = getpid();
  int ppid = getppid();
  printf("pid: %d\n", pid);
  printf("ppid: %d\n", ppid);

  pid = fork();
  if (pid == -1){
    printf("Error!\n");
  } else if (pid == 0) {
    printf("Child process\n");
  } else {
    printf("parent process\n");
  }
}
