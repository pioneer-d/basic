package day8.arrayList;

import java.util.ArrayList;

public class ArrayListClass { // ArrayList예제

	public static void main(String[] args) {

		ArrayList<String> arrayList = new ArrayList<String>();
		// 선언 시 데이터 타입을 명시해주며, 크기는 고정시키지 않아도 된다.

		// 입력은 add로 한다. 코딩 순서대로 index가 부여된다.
		System.out.println("입력 add");
		arrayList.add("str1"); // =index = 0
		arrayList.add("str2"); // =index = 1
		arrayList.add("str3");
		arrayList.add("str4");
		System.out.println("arrayList : "+arrayList);
		System.out.println("arrayList.toString : " + arrayList.toString());

		// 호출은 index로 찾는다.
		System.out.println("호출 get");
		System.out.println("arrayList.get(0) : " + arrayList.get(0));
		System.out.println("arrayList.get(1) : " + arrayList.get(1));

		// 수정은 set으로 한다.
		System.out.println("수정 set");
		arrayList.set(3, "str44");
		System.out.println("arrayList.toString : " + arrayList.toString());

		// 배열의 크기는 size로 얻는다.
		System.out.println("크기 size");
		System.out.println("arrayList.size() : " + arrayList.size());

		// 삭제는 remove로 한다.(1개 삭제)
		System.out.println("삭제 remove");
		arrayList.remove(3);
		System.out.println("arrayList.toString : " + arrayList.toString());
		
		//배열 전부 삭제는 clear로 한다.
		System.out.println("배열 전부 삭제");
		arrayList.clear();
		System.out.println("arrayList.toString : " + arrayList.toString());
		
		//배열에 null넣어보기
		arrayList = null;	//이 말은 배열을 가리키는 주소값을 끊는다고 생각하면 됨.
		System.out.println("arrayList : "+ arrayList);
//		System.out.println("arrayList.size : " + arrayList.size());
		//얘는 없는 객체의 크기를 알려고 하니 오류가 생긴 것.
		
		
	}

}
