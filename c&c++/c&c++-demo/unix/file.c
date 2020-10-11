#include <stdio.h>

int main() {
  FILE *fp = NULL;
  fp = fopen("./resources/test.txt", "w");
  fprintf(fp, "This is a testing for fprintf");
  fclose(fp);
}
