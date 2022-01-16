#include <stdio.h>

//임의의 자연수 N 을 입력 받아 N 을 소인수 분해 한 결과를 출력하여라. 예를 들어서 N = 18 일 경우 N = 18 18 = 2 * 3 * 3

int main()
{
    int num = 0;
    printf("소인수 분해 할 자연수를 입력하시오 : \n");
    scanf("%d",&num);

    printf("%d = ",num);

    for(int i=0; i<100; i++)
    {
        if(num % 2 == 0)
        {
            printf("2");
            num = num/2;
            if(num % 2 == 0 || num % 3 == 0 || num % 5 == 0){printf(" * ");}
            continue;
        }
        else if(num % 3 == 0)
        {
            printf("3");
            num = num/3;
            if(num % 2 == 0 || num % 3 == 0 || num % 5 == 0){printf(" * ");}
            continue;
        }
        else if(num % 5 == 0)
        {
            printf("5");
            num = num/5;
            if(num % 2 == 0 || num % 3 == 0 || num % 5 == 0){printf(" * ");}
            continue;
        }
        else
        {
            if(num != 1)
            {
                printf("* %d",num);
            }
            break;
        }
    }

    return 0;
}
