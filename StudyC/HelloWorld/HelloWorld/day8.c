#include <stdio.h>
#pragma warning(disable:4996)

int main() {

	int num;
	printf("������ �Է��Ͻÿ� : ");

	scanf("%d", &num);

	if (num == 0) {
		printf("�Է��Ͻ� ���ڴ� %d �Դϴ�",num);
	}
	else if (num == 1) {
		printf("�Է��Ͻ� ���� %d �Դϴ�",num);
	}
	else {
		printf("�Է��Ͻ� ���ڴ� 0�� 1�� �ƴմϴ�");
	}

	return 0;
}