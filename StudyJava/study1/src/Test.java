
public class Test {
	
	static int a = 10;
	
	static class InnerClass {
		
		static public void innerMethod() {
			System.out.println("innerMethod");
			System.out.println("outClass�� ���� �������� a : "+a);
		}
		
	}
	
	InnerClass inner = new InnerClass();

	public static void main(String[] args) {
		Test.InnerClass.innerMethod();
	}
}

