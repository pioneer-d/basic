#include <stdio.h>

int main()
{
	int arr[] = { 1,2,3 };
	int* p = arr;	//배열의 이름 그대로 사용시 암묵적으로 배열의 첫번째 원소의 포인터로 변환됨.	하지만 같은 것이 절대 아님!

	printf("Sizeof(arr) : %d \n",sizeof(arr[0]));
	printf("Sizeof(p) : %d", sizeof(p));

	return 0;
}

