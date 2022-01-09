#include <stdio.h>

int main()  //수를 입력받아 1부터 입력받은 수까지의 곱 구하기.
{
    int num;
    int cal = 1;

    printf("자연수를 입력하시오 : ");
    scanf("%d", &num);

    for(int i = 1; i<num+1; i++)
    { 
        cal *= i; 
    }
    printf("1부터 %d 까지의 곱 : %d",num,cal);

    return 0;
}