#include <stdio.h>

int main() {
	int a = 2147483647;	//int�� �ִ밪
	printf("a : %d \n ", a);

	a++;	//�ִ밪�� ������ ������ ǥ����.
	printf("a : %d \n", a);

	a++;	//�� �ڷ� �� �߰��ϴ� ���� +1 ���·� ����.
	printf("a : %d \n", a);

	unsigned int b = -1;
	printf("b : %u \n", b);

	unsigned int c = 4294967295;
	c++;
	printf("c : %u \n", c);

	return 0;
}