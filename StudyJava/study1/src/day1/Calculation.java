package day1;

public class Calculation {	//�����ϰ� �����ڿ� ���� �˾ƺ���

	public static void main(String []args) {
		int i = 10;
		int j = 5;
		
		//�������
		System.out.println("���� = "+(i + j));
		System.out.println("���� = "+(i - j));
		System.out.println("������ = "+(i/j));
		System.out.println("���� ������ = "+(i%j));
		
		//��������
		System.out.println(i++);	//�̰��� ����ϸ� 10�̶�� ���. ����̶�� ���� �� ������ �ϴ°�.
		System.out.println(j--);	//�̰͵� ��������.
		
		System.out.println(i);		//������� i�� 11�� �Ǵ°��̴�.
		System.out.println(j);		//�̰͵� ��������.
		
		//��������
		System.out.println(i==j);
		System.out.println(i>j && i>=j);	//�Ѵ� �¾ƾ�
		System.out.println(i>j || i<j);		//���� �ϳ��� �¾ƾ�
		System.out.println(i<j);
		
	}
}
