#include <stdio.h>

int main()	//�迭�� �ּ� ���۰��� Ȱ���� �����ͷ� �迭�� ���� �˾Ƴ���
{
	int arr[] = { 1,2,3 };
	int* p = &arr[0];

	printf("arr[%d]�� �� : %d \n",2,arr[2]);
	printf("(p+%d)�� �� : %d",2,*p+2);

	return 0;
}