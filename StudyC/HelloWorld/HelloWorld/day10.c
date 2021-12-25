#include <stdio.h>

main(){
    int array1[5] = {1,2,3,4,5};    //배열 선언 방법1
    int array2[] = {6,7,8,9,10};      //배열 선언 방법2

    printf("array1[0] : %d \n", array1[0]);
    printf("array2[2] : %d \n", array2[2]);

    int array3[7] = {11,22,33,44,55,66,77};

    for(int i = 0; i<sizeof(array3)/sizeof(int); i++){
        //배열 사이즈 바이트값 = sizeof(array)
        //int의 사이즈 바이트 값 = sizeof(int)
        //2번째로 1번째를 나누면 배열의 개수가 나온다.
        printf("array3의 %d 번째 value : %d \n", i, array3[i]);
    }

    return 0;
}