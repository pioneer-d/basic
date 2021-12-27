#include <stdio.h>

int main() {

	//2차원 배열
	int array1[3][3] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	printf("array1의 2행 3열은? : %d \n", array1[1][2]);	//6일 것.
	printf("array1의 1행 2열은? : %d", array1[0][1]);		//2일 것.


	return 0;
}