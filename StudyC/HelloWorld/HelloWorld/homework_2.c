#include <stdio.h>

int main(){ ////�Է¹޴� ���� �ﰢ���� ���̰� �Ǵ� ���ﰢ�� �����

    int n = 0;
    printf("������ �Է��Ͻÿ� : ");
    scanf("%d", &n);

    for(int i = 0; i<(n+1); i++)    //�ݺ��Ǵ� �� ���
    {
    
    for(int j = 0; j<i; j++)    //���� ���� ���
    {       
        printf(" ");
    }

    for(int z = 0; z<(2*n-1)-(2*i); z++)    //��� �� ���
    {   
        printf("*");
    }

    for(int j = 0; j<i; j++)    //���� ���� ���
    {
        printf(" ");
    }

    printf("\n");

    }
    return 0;
}