#include<stdio.h>
#include<string.h>
int main(int argc, char const *argv[])
{
    char str[25] = {'a','b','c'};
    // printf("Enter\n");
    // scanf("%s",str);
    
    // gets(str);
    for (int i = 0; i < 4; i++)
    {
        if (str[i]=='\0')
        {
            printf("Yes");
        }
        
    }
    
    return 0;
}
