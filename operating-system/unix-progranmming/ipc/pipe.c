#include <stdio.h>

int main(){
  int fd[2];
  if(pipe(fd) < 0){
    printf("Create pipe error");
  }
}

