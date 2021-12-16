#include <stdio.h>
#pragma warning(disable:4996)

int main() {

	int num;
	printf("정수를 입력하시오 : ");

	scanf("%d", &num);

	if (num == 0) {
		printf("입력하신 숫자는 %d 입니다",num);
	}
	else if (num == 1) {
		printf("입력하신 숫자 %d 입니다",num);
	}
	else {
		printf("입력하신 숫자는 0도 1도 아닙니다");
	}

	return 0;
}