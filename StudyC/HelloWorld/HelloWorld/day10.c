#include <stdio.h>

main(){
    int array1[5] = {1,2,3,4,5};    //�迭 ���� ���1
    int array2[] = {6,7,8,9,10};      //�迭 ���� ���2

    printf("array1[0] : %d \n", array1[0]);
    printf("array2[2] : %d \n", array2[2]);

    int array3[7] = {11,22,33,44,55,66,77};

    for(int i = 0; i<sizeof(array3)/sizeof(int); i++){
        //�迭 ������ ����Ʈ�� = sizeof(array)
        //int�� ������ ����Ʈ �� = sizeof(int)
        //2��°�� 1��°�� ������ �迭�� ������ ���´�.
        printf("array3�� %d ��° value : %d \n", i, array3[i]);
    }

    return 0;
}