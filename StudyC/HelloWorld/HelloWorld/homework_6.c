#include <stdio.h>

int main()  // a + b + c = 2000     &&      a > b > c (��� �ڿ���.)
{
    int a;
    int b;
    int c;
    int count;

    for(c = 1997; c>667; c--)
    {
        for(int i = 2; i<c; i++)
        {
            b = i;
            if(b+c > 1999) continue;    
            for(a = 1; a<b; a++){
                if(a+b+c > 2000) continue;
                if(a+b+c == 2000) count++;
            }
        }
    }

    printf("������ �����ϴ� ���� : %d",count);
    return 0;
}
