#include <stdio.h>

main(){
    int n = 0;  //�Է� �޴� ����(�ﰢ���� �� ������ �ǹ�)
    printf("������ �Է��ϼ��� : ");
    scanf("%d", &n);

    for(int i = 0; i<n; i++){
        
        for(int j = 0; j<(n-i); j++){   //�ﰢ���� (���η�)������ ������ ���� ���� ���
            printf(" ");
        }

        for(int z = 0; z<(2*i-1); z++){ //��� �� ���
            printf("*");
        }
 
        for(int j = 0; j<(n-i); j++){   //���� ���� ���
            printf(" ");
        }
        printf("\n");                   //���� ��
    }
    return 0;
}