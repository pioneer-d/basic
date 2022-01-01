#include <stdio.h>

int main(){ ////입력받는 수가 삼각형의 높이가 되는 역삼각형 만들기

    int n = 0;
    printf("정수를 입력하시오 : ");
    scanf("%d", &n);

    for(int i = 0; i<(n+1); i++)    //반복되는 행 담당
    {
    
    for(int j = 0; j<i; j++)    //좌측 공백 담당
    {       
        printf(" ");
    }

    for(int z = 0; z<(2*n-1)-(2*i); z++)    //가운데 별 담당
    {   
        printf("*");
    }

    for(int j = 0; j<i; j++)    //좌측 공백 담당
    {
        printf(" ");
    }

    printf("\n");

    }
    return 0;
}