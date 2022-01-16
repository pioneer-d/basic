#include <stdio.h>

int print_hello()   //출력용 함수 
{
    printf("함수 테스트 하기 \n");
    return 0;
}

int get_1000(){ return 1000; }

int calculater(int a, int b)
{
    int c = a+b;
    return c;
}

int main() //함수 활용 test
{
    print_hello();

    int a = get_1000();
    printf("get_1000을 통해 얻은 a의 값 : %d \n",a);

    int calNum = calculater(3,7);
    printf("인자를 입력하는 계산 함수를 거친 calNum의 값 : %d \n",calNum);

    return 0;
}