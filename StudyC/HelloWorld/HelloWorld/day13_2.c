#include <stdio.h>

int main()	//배열의 주소 시작값을 활용한 포인터로 배열의 원소 알아내기
{
	int arr[] = { 1,2,3 };
	int* p = &arr[0];

	printf("arr[%d]의 값 : %d \n",2,arr[2]);
	printf("(p+%d)의 값 : %d",2,*p+2);

	return 0;
}