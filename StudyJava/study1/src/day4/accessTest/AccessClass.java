package day4.accessTest;

public class AccessClass {	//���������� ����
	
	
	private int a = 10;
	int b = 11;				//�̷��� ���������ڰ� ������ ��� default�� ����ȴ�.(public�ΰ�..?)
	protected int c = 12;
	public int d = 13;
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	
	//������������ ������ ũ�� 4���� �ִ�.
	//private	������Ű�� �������� ���� Ŭ���������� ���� ����
	//default	������Ű�� ������ ��� ���� ����
	//protected	������Ű�� + �ܺ���Ű�� �� ��ӹ��� ����Ŭ������ ���� ����
	//public	��𼭵� ���� ����
	
	

}
