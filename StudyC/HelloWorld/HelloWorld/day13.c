#include <stdio.h>

int main()	//배열에 저장된 각 원소들이 메모리 상에서 연속적으로 놓이는지 확인.
{
	int arr[] = { 1,2,3,4,5 };

	for (int i = 0; i < 5; i++)
	{
		printf("arr[%d]의 주소값 : %p \n", i, &arr[i]);
	}

}