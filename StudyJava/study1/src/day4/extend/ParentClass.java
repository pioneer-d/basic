package day4.extend;

public class ParentClass {	//����� ����
	
	String parent = "�θ��� String";
	
	public ParentClass() {
		// TODO Auto-generated constructor stub
	}
	
	public void getPapaName() {
		System.out.println("�ƺ��̸� ��������");
	}
	
	public void getMamaName() {
		System.out.println("�����̸� ��������");
	}
	
	public void getChange() {	//Overriding�ؼ� �ڽ��� �ٲ㺸��
		System.out.println("�ڽĵ����� ������ �ؼ� ���������");
	}

}
