#include <stdio.h>

int plus_arr(int *parr);

int main()
{
    int arr[3];

    for(int i = 0; i<3; i++)
    {
        printf("%d��° �迭�� ���� �Է� : \n",i);
        scanf("%d", &arr[i]);
    }

    plus_arr(arr);

    printf("�Լ��� ��ģ �� �迭�� �� ���� �� : %d, %d, %d",arr[0],arr[1],arr[2]);
    return 0;
}

int plus_arr(int *parr)
{
    for(int i = 0; i<3; i++)
    {
        parr[i] += 1;
    }
    return 0;
}