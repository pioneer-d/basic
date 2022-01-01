#include <stdio.h>

int main()
{
    char c;
    int i;
    double d;

    char* cp = &c;
    int* ip = &i;
    double* dp = &d;

    printf("char형 포인터에 +1 하기전 : %p \n", cp);
    printf("int형 포인터에 +1 하기전 : %p \n", ip);
    printf("double형 포인터에 +1 하기전 : %p \n", dp);

    printf("\n");
    cp = cp+1;
    ip = ip+1;
    dp = dp+1;

    printf("char형 포인터에 +1 한 후 : %p \n", cp);     //1byte증가 함.
    printf("int형 포인터에 +1 한 후 : %p \n", ip);      //4byte증가 함.
    printf("double형 포인터에 +1 한 후 : %p \n", dp);   //8byte증가 함.

    return 0;

}