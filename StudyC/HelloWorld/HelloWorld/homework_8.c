#include <stdio.h>

int main()  //�� �Է¹޴� �л����� ������ ���� ������ �����ϴ� ���α׷�.
{
    int num;
    int dum;    //���� ���Ŀ� Ȱ���� �ӽú���

    printf("�л��� ���� �Է��ϼ��� : \n");
    scanf("%d", &num);

    int score[num];

    for(int i=0; i<num; i++)
    {
        printf("%d��° ������ �Է��ϼ��� \n: ",i);
        scanf("%d",&score[i]);
    }

    //���� ���� ����ϱ� (���� �۰ų� ū ������ ���� �� �迭�� �ݺ��Ͽ� �ű�� ���.)
    for(int i=0; i<num-1; i++)
    {
        for(int j=0; j<num-i-1; j++)
        {
            if(score[j] < score[j+1])
            {
                dum = score[j];
                score[j] = score[j+1];
                score[j+1] = dum;
            }
        }
    }

    for(int i=0; i<num; i++)
    {
        printf("%d \n",score[i]);
    }

return 0;
}