#include <stdio.h>

int main()  //위 입력받는 학생들의 성적을 높은 순으로 정렬하는 프로그램.
{
    int num;
    int dum;    //버블 정렬에 활용할 임시변수

    printf("학생의 수를 입력하세요 : \n");
    scanf("%d", &num);

    int score[num];

    for(int i=0; i<num; i++)
    {
        printf("%d번째 성적을 입력하세요 \n: ",i);
        scanf("%d",&score[i]);
    }

    //버블 정렬 사용하기 (제일 작거나 큰 변수를 한쪽 끝 배열로 반복하여 옮기는 방법.)
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