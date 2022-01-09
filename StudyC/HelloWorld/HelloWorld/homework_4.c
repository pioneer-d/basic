#include <stdio.h>

int main()      //1000000 이하의 피보나치 수열 중 짝수의 합 구하기.
{
    int num1 = 0;
    int num2 = 1;
    int fibo;

    int sum;

    for(int i = 1; i<100; i++)
    {
        if(i == 1)
        {
            fibo = 1;
        }
        else
        {
            fibo = num1 + num2;
            if(i%2 == 0)
            {
                sum += fibo;
                printf("피보나치의 짝수 항 더해주기 : %d \n", fibo);
            }
            num1 = num2;
            num2 = fibo;
            
            if(fibo > 1000000){
                break;
            }
        }
        printf("피보나치 수열 : %d \n",fibo);
    }
    printf("총합 : %d", sum);

    return 0;
}