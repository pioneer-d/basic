#include <stdio.h>

int main() 
{

    ////////////////////////////////////////////////////
    const int* p;
    const int* p1;
    int a;
    int b;

    // 데이터가 있는 변수를 포인터에 입력하는 방식
    a = 2;  
    p = &a; 
    printf("p에 입력된 변수의 데이터 : %d \n", *p);
    printf("p의 주소값 : %p \n",p);
    a = 4;
    printf("p에 입력된 변수의 데이터(데이터 변경함) : %d \n", *p);
    printf("p의 주소값 : %p \n",p);
    //*p = 2;       //올바르지 않은 형태.

    // 데이터가 없는 변수를 포인터에 입력한 뒤 데이터를 입력하는 방식
    p1 = &b;
    b = 3;
    printf("p1에 입력된 변수의 데이터 : %d", *p1);
    printf("p의 주소값 : %p \n",p1);    //바뀐다...?

    ////////////////////////////////////////////////////const가 뒤에 있는경우
    int c;
    int d;
    int* const p3 = &c;
    int* const p4 = &d;

    //p3 = &c;  이처럼 선언할 때 말고는 절대로 입력될 수 없는 것 같다.
    //p3 = &d;  이경우는 처음 선언한 변수 이외에는 전부 차단하므로 에러가 나옴.
    *p3 = 4;
    d = 5;

    return 0;

}