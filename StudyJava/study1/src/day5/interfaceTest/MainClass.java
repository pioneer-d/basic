package day5.interfaceTest;

public class MainClass {
	
	public static void main(String[] args) {
		
		//�ΰ��� interface�� ����ϴ� Ŭ������ ��üŸ���� ���
		InterfaceImplementClass inter = new InterfaceImplementClass();
		
		//�ΰ��� interface�� �޼ҵ带 ��� ��� �����ϴ�.
		inter.method1();
		inter.method2();
		
		//�ϳ��� �������̽��� ��üŸ���� ���
		Interface1 inter1 = new InterfaceImplementClass();
		
		//��ü�� �ΰ����� �������̽��� �����������, ��üŸ���� �޼ҵ常 ��� �����ϴ�.
		inter1.method1();
//		inter1.method2();	����!
		
		//�̰͵� �ٷ����� ��ʿ� ����.
		Interface2 inter2 = new InterfaceImplementClass();
		
	}

}
