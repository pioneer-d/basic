#include <stdio.h>

int main()	//�迭�� ����� �� ���ҵ��� �޸� �󿡼� ���������� ���̴��� Ȯ��.
{
	int arr[] = { 1,2,3,4,5 };

	for (int i = 0; i < 5; i++)
	{
		printf("arr[%d]�� �ּҰ� : %p \n", i, &arr[i]);
	}

}