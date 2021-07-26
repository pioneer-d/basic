package day8.arrayList;

import java.util.ArrayList;

public class ArrayListClass { // ArrayList����

	public static void main(String[] args) {

		ArrayList<String> arrayList = new ArrayList<String>();
		// ���� �� ������ Ÿ���� �������ָ�, ũ��� ������Ű�� �ʾƵ� �ȴ�.

		// �Է��� add�� �Ѵ�. �ڵ� ������� index�� �ο��ȴ�.
		System.out.println("�Է� add");
		arrayList.add("str1"); // =index = 0
		arrayList.add("str2"); // =index = 1
		arrayList.add("str3");
		arrayList.add("str4");
		System.out.println("arrayList : "+arrayList);
		System.out.println("arrayList.toString : " + arrayList.toString());

		// ȣ���� index�� ã�´�.
		System.out.println("ȣ�� get");
		System.out.println("arrayList.get(0) : " + arrayList.get(0));
		System.out.println("arrayList.get(1) : " + arrayList.get(1));

		// ������ set���� �Ѵ�.
		System.out.println("���� set");
		arrayList.set(3, "str44");
		System.out.println("arrayList.toString : " + arrayList.toString());

		// �迭�� ũ��� size�� ��´�.
		System.out.println("ũ�� size");
		System.out.println("arrayList.size() : " + arrayList.size());

		// ������ remove�� �Ѵ�.(1�� ����)
		System.out.println("���� remove");
		arrayList.remove(3);
		System.out.println("arrayList.toString : " + arrayList.toString());
		
		//�迭 ���� ������ clear�� �Ѵ�.
		System.out.println("�迭 ���� ����");
		arrayList.clear();
		System.out.println("arrayList.toString : " + arrayList.toString());
		
		//�迭�� null�־��
		arrayList = null;	//�� ���� �迭�� ����Ű�� �ּҰ��� ���´ٰ� �����ϸ� ��.
		System.out.println("arrayList : "+ arrayList);
//		System.out.println("arrayList.size : " + arrayList.size());
		//��� ���� ��ü�� ũ�⸦ �˷��� �ϴ� ������ ���� ��.
		
		
	}

}