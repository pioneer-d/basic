#include <stdio.h>

int main()      //1000000 이하의 피보나치 수열 중 짝수의 합 구하기.
{
    int num1;
    int num2 = 1;
    int fibo;

    int sum;

    for(int i = 1; i<1000001; i++)
    {
        fibo = num1 + num2;
        if(fibo%2 == 0)
        {
            sum += fibo;
            printf("피보나치 2의배수 더해주기 : %d \n", fibo);
        }
        num1 = num2;
        num2 = fibo;
        
        if(fibo == 1000001){
            break;
        }
    }
    printf("총합 : %d", sum);

    return 0;
}