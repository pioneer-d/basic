package day9.inputOutput;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainClassOutput {
	
	public static void main(String[] args) {
		
		OutputStream os = null;
		
		try {
			//�ش� ������ ������ �����!
			os = new FileOutputStream("C:\\GitHub\\testOutput.txt");
			String str = "������ ������ �ʹ� ����.";
			byte[] bs =  str.getBytes();	//String���� byte�� ��ȯ
			os.write(bs);	//�Է�!
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {	//�������� �ݾ��ֱ�.
			try {
				if(os != null) os.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
	}

}
