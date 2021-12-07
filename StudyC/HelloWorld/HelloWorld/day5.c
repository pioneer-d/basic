#include <stdio.h>

int main() {
	int a = 0xAF;	//10101111
	int b = 0xB5;	//10110101

	printf("%d \n", a & b);		//10100101
	printf("%d \n", a | b);		//10111111
	printf("%d \n", a ^ b);		//00011010
	printf("%d \n", ~a);		//01010000
	printf("%d \n", a << 2);	//10111100
	printf("%d \n", a >> 3);	//00010110

	return 0;
}