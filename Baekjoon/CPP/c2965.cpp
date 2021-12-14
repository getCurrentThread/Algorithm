#include <stdio.h>

int main() {
    int a, b, c;
    int diff[2];
    scanf("%d %d %d", &a, &b, &c);
    diff[0] = b - a - 1;
    diff[1] = c - b - 1;
    if (diff[0] < diff[1]) printf("%d", diff[1]);
    else printf("%d", diff[0]);
    return 0;
}