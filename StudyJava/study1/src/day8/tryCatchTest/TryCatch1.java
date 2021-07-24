package day8.tryCatchTest;

public class TryCatch1 {

	public static void main(String[] args) {

		int i = 10;
		int j = 0;

		System.out.println("i+j : " + i + j);
		System.out.println("i-j : " + (i - j));
		System.out.println("i*j : " + i * j);
		try {	//������ ���� ���� try�� ���� catch�� ó���� �Ѵ�. 
			System.out.println("i/j : " + i / j);
		} catch (Exception e) {		//catch���� �������� �� �� �ִ�.
			System.out.println(e.getMessage());	//e.getMessage�� ���� �������� ����ϴ� �޼ҵ�
			e.printStackTrace();	//�̰� ���� �� �ڼ��� ���� �żҵ�
			
		}finally {	//try�� catch���� ������� �ʾƵ� ������ ����Ǵ� �޼ҵ��̴�.
					//������ �߻��ϵ� ���ϵ� ������ ����ȴ�.
			System.out.println("������ ����Ǵ� �޼ҵ�");
			
		}
	}

}
