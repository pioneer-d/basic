package day2.loop;

public class ForTest2 {		//for���� Ȱ���Ͽ� 1���� 10������ �� ���غ���
	public static void main(String[] args) {
		
		int sum = 0;
		for(int i = 1; i<11; i++) {
			System.out.println(sum);
			sum += i;
			//sum =+i �̰��� sum = +i(���� ����) �̰Ͱ� ����.
		}
		
		System.out.println(sum);
	}

}
