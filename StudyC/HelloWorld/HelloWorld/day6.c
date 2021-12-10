#include <stdio.h>

int main() {
	int a = 2147483647;	//int의 최대값
	printf("a : %d \n ", a);

	a++;	//최대값을 넘으니 음수로 표현됨.
	printf("a : %d \n", a);

	a++;	//그 뒤로 또 추가하니 음수 +1 형태로 나옴.
	printf("a : %d ", a);

	return 0;
}