#include <stdio.h>

int main()      //1000000 ������ �Ǻ���ġ ���� �� ¦���� �� ���ϱ�.
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
            printf("�Ǻ���ġ 2�ǹ�� �����ֱ� : %d \n", fibo);
        }
        num1 = num2;
        num2 = fibo;
        
        if(fibo == 1000001){
            break;
        }
    }
    printf("���� : %d", sum);

    return 0;
}