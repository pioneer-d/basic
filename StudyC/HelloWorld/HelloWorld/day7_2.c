#include <stdio.h>
#pragma warning(disable:4996) 

int main() {
	char ch;	//����

	short sh;	//����
	int i;
	long lo;

	float fl;	//�Ǽ�
	double du;	

	printf("char�� ���� �Է� : ");
	scanf("%c", &ch);

	printf("short�� ���� �Է� : ");
	scanf("%hd", &sh);

	printf("int�� ���� �Է� : ");
	scanf("%d", &i);

	printf("long�� ���� �Է� : ");
	scanf("%ld", &lo);

	printf("float�� ���� �Է� : ");
	scanf("%f", &fl);

	printf("double�� ���� �Է� : ");
	scanf("%lf", &du);

	printf("char : %c, shor : %d, int : %d \n" , ch, sh, i);
	printf("long : %ld, float : %f, double : %f \n", lo, fl, du);

	return 0;
}