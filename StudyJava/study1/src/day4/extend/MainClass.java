package day4.extend;

public class MainClass {	//�ڽ�Ŭ������ ��ü�����Ͽ� �θ��� Ŭ������ ����� �������� ����
	
	public static void main(String[] args) {
		
		ChildClass cc = new ChildClass();
		
		String getString = cc.parent;
		System.out.println(getString);
		
		cc.getPapaName();
		cc.getMamaName();
		cc.getChange(); 	//�� �޼ҵ�� �ڽ��� �������� �޼ҵ�. Overriding�� ����ߴ�.
		
	}

}