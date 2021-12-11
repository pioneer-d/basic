#include <stdio.h>

int main(){
    double celsius; //?꽠?뵪?삩?룄

    printf("섭씨 온도를 입력해 주세요. : ");
    scanf("%lf", &celsius);

    printf("섭씨 %f 도는 화씨로 %f 도 입니다.",celsius, 9*celsius / 5 + 32);

    return 0;

}