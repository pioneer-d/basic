package day5.abstractTest;

public abstract class HeadStore {	//�߻�Ŭ������ ����
	
	public HeadStore() {
		// TODO Auto-generated constructor stub
	}
	
	//�߻�޼ҵ�� ������ ����. ���� ������.
	public abstract void chicken();
	
	public abstract void pizza();
	
	public abstract void coffee();
	
	public void test() {
		System.out.println("�Ϲ� �޼ҵ��?");
	}

}