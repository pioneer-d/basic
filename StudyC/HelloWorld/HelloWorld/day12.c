#include <stdio.h>

int main(){     //������ �н��ϱ�

    int* p; //������ ����
    int a;  

    a = 2;
    p = &a; //a�� �ּҰ� �����Ϳ� ����

    //�Ʒ��� 2�� ���� ���� ��.
    printf("a�� �ּҰ� :  %p \n", &a);
    printf("p�� ��°� : %p \n", p);

    //�Ʒ��� 2�� ���� ���� ��.
    printf("a�� ������ �� : %d \n", a);
    printf("p�� �Էµ� �ּҰ��� ��ġ�� �������� �� : %d \n", *p);

    int *p2;
    int b;

    p2 = &b;
    *p2 = 3;

    printf("*p2�� b�� ���� ���ΰ�? %d, %d", *p2, b);


    return 0;
}