package day9.hashSet;

public class Student {	//HashSet �����ϱ�.
	
	private String name;
	private int grade;
	
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	//mainŬ�������� �������� ������ ���캸��.
	@Override
		public String toString() {
			return name+" : "+grade;
		}
	
	//�Ʒ��� 2���� �ڵ� ������ 2���� ���� �ٸ� "��±�"�� ���� ��ü�� �νĵɰ���! 
	@Override
		public boolean equals(Object obj) {
			String compareValue = obj.toString();
			String thisValue = toString();
			return thisValue.equals(compareValue);
		}
	
	@Override
		public int hashCode() {
		//hashCode�� �޸��� �ּҸ� �ڵ�ȭ �ؼ� �����ϴ� �޼ҵ��̴�.
		//�̸� ���Ƿ� toString()�� hashCode�� �����߱⿡ ��������!
		
			return toString().hashCode();
		}
	
}
