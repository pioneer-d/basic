#include <stdio.h>

int main()
{
	int arr[] = { 1,2,3,4,5 };
	int* pointt;

	pointt = &arr[0];

	for (int i = 0; i < 5; i++)
	{
		printf("arr[%d]�� �ּҰ� : %p  ", i, &arr[i]);
		printf("(pointt + %d)�� �� : %p  ", i, pointt + i);

		if (&arr[i] == (pointt + i))
		{
			printf("��ġ! \n");
		}
		else
		{
			printf("����ġ! \n");
		}
	}

	return 0;
}