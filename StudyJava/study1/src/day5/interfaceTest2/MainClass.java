package day5.interfaceTest2;

public class MainClass {
	
	public static void main(String[] args) {
		
		//�ڱ��ڽ��� ��üŸ���� ��� -> �ϳ��� �迭�� ���� �� ����.
		APhone ap = new APhone();
		BPhone bp = new BPhone();
		CPhone cp = new CPhone();
		
		//ISpec�� ��üŸ���ΰ�� (��üŸ���� ����)
		ISpec ap1 = new APhone();
		ISpec bp1 = new BPhone();
		ISpec cp1 = new CPhone();
		
		//�迭������ �Ҷ� ���� Ÿ���� �����͸� ���� ���� �� �ִ�!!!
		//�׷��Ƿ� ISpec���� ��üŸ���� ������ �ֵ鳢���� ���� �� �ִ�.
		ISpec[] is = {ap1,bp1,cp1};
		
		for(int i = 0; i<is.length; i++) {
			is[i].canLTE();
			is[i].canSamsongPay();
			is[i].canCall();
			System.out.println("");
		}
		
	}
	


}