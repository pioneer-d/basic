#include <stdio.h>

int print_hello()   //��¿� �Լ� 
{
    printf("�Լ� �׽�Ʈ �ϱ� \n");
    return 0;
}

int get_1000(){ return 1000; }

int calculater(int a, int b)
{
    int c = a+b;
    return c;
}

int main() //�Լ� Ȱ�� test
{
    print_hello();

    int a = get_1000();
    printf("get_1000�� ���� ���� a�� �� : %d \n",a);

    int calNum = calculater(3,7);
    printf("���ڸ� �Է��ϴ� ��� �Լ��� ��ģ calNum�� �� : %d \n",calNum);

    return 0;
}