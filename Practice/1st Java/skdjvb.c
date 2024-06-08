#include<stdio.h>
int main(int argc, char const *argv[])
{
    int a,b;
    int *p,*q;
     a =10;
     b =5;
    p = &a;
    // b = *p;
    q = &b;

    int c = p-q;
    printf("%d",c);

 
    // printf("%d",b);
    
    return 0;
}
