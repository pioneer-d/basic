#include <stdio.h>

int main(){     //포인터 학습하기

    int* p; //포인터 선언
    int a;  

    a = 2;
    p = &a; //a의 주소값 포인터에 대입

    //아래의 2개 값이 같을 것.
    printf("a의 주소값 :  %p \n", &a);
    printf("p의 출력값 : %p \n", p);

    //아래의 2개 값이 같을 것.
    printf("a의 데이터 값 : %d \n", a);
    printf("p에 입력된 주소값에 위치한 데이터의 값 : %d \n", *p);

    int *p2;
    int b;

    p2 = &b;
    *p2 = 3;

    printf("*p2와 b는 같은 것인가? %d, %d", *p2, b);


    return 0;
}