#include <stdio.h>

int main()      //1000000 ������ �Ǻ���ġ ���� �� ¦���� �� ���ϱ�.
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
                printf("�Ǻ���ġ�� ¦�� �� �����ֱ� : %d \n", fibo);
            }
            num1 = num2;
            num2 = fibo;
            
            if(fibo > 1000000){
                break;
            }
        }
        printf("�Ǻ���ġ ���� : %d \n",fibo);
    }
    printf("���� : %d", sum);

    return 0;
}