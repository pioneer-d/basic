#include <stdio.h>

int main()
{
	int arr[] = { 1,2,3 };
	int* p = arr;	//�迭�� �̸� �״�� ���� �Ϲ������� �迭�� ù��° ������ �����ͷ� ��ȯ��.	������ ���� ���� ���� �ƴ�!

	printf("Sizeof(arr) : %d \n",sizeof(arr[0]));
	printf("Sizeof(p) : %d", sizeof(p));

	return 0;
}

