
public class Test {
	
	public static void main(String []args) {
		
		A a = new A(1);
		A b = a;
		
		b.a = 2;
		System.out.println(a.a);
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		
	}

}

class A{
	int a;
	public A(int a) {
		this.a = a;
	}
}
