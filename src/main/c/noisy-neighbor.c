#include <unistd.h>
#include <stdio.h>

int main() {
    int n1 = fork();
    int n2 = fork();
    int n3 = fork();
    int n4 = fork();

    int j = 0;
    for (long i = 0; i < 100000000000; i++) {
        j *= i;
    }
}