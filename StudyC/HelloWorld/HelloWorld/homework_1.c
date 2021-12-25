#include <stdio.h>

main(){
    int n = 0;  //입력 받는 변수(삼각형의 행 개수를 의미)
    printf("정수를 입력하세요 : ");
    scanf("%d", &n);

    for(int i = 0; i<n; i++){
        
        for(int j = 0; j<(n-i); j++){   //삼각형을 (세로로)반으로 나누어 좌측 공백 담당
            printf(" ");
        }

        for(int z = 0; z<(2*i-1); z++){ //가운데 별 담당
            printf("*");
        }
 
        for(int j = 0; j<(n-i); j++){   //우측 공백 담당
            printf(" ");
        }
        printf("\n");                   //다음 줄
    }
    return 0;
}