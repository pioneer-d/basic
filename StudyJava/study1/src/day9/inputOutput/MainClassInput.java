package day9.inputOutput;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainClassInput {
	
	public static void main(String[] args) {
		
		try {	//������� ���� ����ó���� �ؾ� �����ϴ�.
			//FileInputStream�� InputStream�� ��ӹ��� Ŭ���� �� �ϳ�.
		InputStream is = new FileInputStream("C:\\GitHub\\testInput.txt");
		while(true) {
			int i = is.read();	//�д´�!
			System.out.println("������ : "+i);	//�ش� �����͸� byte�� ��ȯ�Ͽ� ���� ���� ����ϱ�.
			if(i == -1)break;
			//�����Ͱ� ���� ��� -1�� �����ϱ� ������ -1���� break�Ѵ�.
		}
		
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}