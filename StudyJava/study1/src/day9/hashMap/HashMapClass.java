package day9.hashMap;

import java.util.HashMap;

public class HashMapClass {	//hashMap����

	public static void main(String[] args) {
		
		//index�� ���� ����, key�� value�� �����Ǿ� �ִ�.
		HashMap <Integer,String> hash = new HashMap <Integer,String>();
		
		//�Է�
		hash.put(0, "test0");
		hash.put(1, "test1");
		hash.put(2, "test2");
		System.out.println(hash);
		
		//ȣ��
		System.out.println("hash.get(0) : "+hash.get(0));
		
		//����
		hash.remove(0);
		System.out.println("remove(0) : "+hash);
		
		//���λ���
		hash.clear();
		System.out.println("clear : "+hash);
		
		//iterator��� ���䵵 �ִ�.

	}
}