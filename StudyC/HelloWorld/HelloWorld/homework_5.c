#include <stdio.h>

int main()  //���� �Է¹޾� 1���� �Է¹��� �������� �� ���ϱ�.
{
    int num;
    int cal = 1;

    printf("�ڿ����� �Է��Ͻÿ� : ");
    scanf("%d", &num);

    for(int i = 1; i<num+1; i++)
    { 
        cal *= i; 
    }
    printf("1���� %d ������ �� : %d",num,cal);

    return 0;
}