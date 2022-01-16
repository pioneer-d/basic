#include <stdio.h>

int plus_arr(int *parr);

int main()
{
    int arr[3];

    for(int i = 0; i<3; i++)
    {
        printf("%d번째 배열의 원소 입력 : \n",i);
        scanf("%d", &arr[i]);
    }

    plus_arr(arr);

    printf("함수를 거친 후 배열의 각 원소 값 : %d, %d, %d",arr[0],arr[1],arr[2]);
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