#include <stdio.h>

int change_num(int *num);   //�̰��� �Լ��� ���� prototype��.

int main()      //�����͸� ���� �������� �����ϱ� + prototype Ȱ���ϱ�
{
    int test = 0;

    printf("�Լ��� ��ġ�� �� test�� : %d \n",test);
    change_num(&test);
    printf("�Լ��� ���� �ٲ� test�� : %d \n",test);
    return 0;
}

int change_num(int *num)
{
    *num = 5;

    return 0;
}