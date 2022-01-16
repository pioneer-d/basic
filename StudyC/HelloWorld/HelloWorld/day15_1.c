#include <stdio.h>

int change_num(int *num);   //이것이 함수의 원형 prototype임.

int main()      //포인터를 통해 지역변수 변경하기 + prototype 활용하기
{
    int test = 0;

    printf("함수를 거치기 전 test값 : %d \n",test);
    change_num(&test);
    printf("함수를 통해 바뀐 test값 : %d \n",test);
    return 0;
}

int change_num(int *num)
{
    *num = 5;

    return 0;
}