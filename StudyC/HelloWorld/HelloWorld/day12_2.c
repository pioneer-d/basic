#include <stdio.h>

int main()
{
    char c;
    int i;
    double d;

    char* cp = &c;
    int* ip = &i;
    double* dp = &d;

    printf("char�� �����Ϳ� +1 �ϱ��� : %p \n", cp);
    printf("int�� �����Ϳ� +1 �ϱ��� : %p \n", ip);
    printf("double�� �����Ϳ� +1 �ϱ��� : %p \n", dp);

    printf("\n");
    cp = cp+1;
    ip = ip+1;
    dp = dp+1;

    printf("char�� �����Ϳ� +1 �� �� : %p \n", cp);     //1byte���� ��.
    printf("int�� �����Ϳ� +1 �� �� : %p \n", ip);      //4byte���� ��.
    printf("double�� �����Ϳ� +1 �� �� : %p \n", dp);   //8byte���� ��.

    return 0;

}