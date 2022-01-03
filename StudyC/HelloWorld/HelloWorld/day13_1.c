#include <stdio.h>

int main()
{
	int arr[] = { 1,2,3,4,5 };
	int* pointt;

	pointt = &arr[0];

	for (int i = 0; i < 5; i++)
	{
		printf("arr[%d]의 주소값 : %p  ", i, &arr[i]);
		printf("(pointt + %d)의 값 : %p  ", i, pointt + i);

		if (&arr[i] == (pointt + i))
		{
			printf("일치! \n");
		}
		else
		{
			printf("불일치! \n");
		}
	}

	return 0;
}