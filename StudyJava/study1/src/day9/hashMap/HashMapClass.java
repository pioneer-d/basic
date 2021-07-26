package day9.hashMap;

import java.util.HashMap;

public class HashMapClass {	//hashMap이해

	public static void main(String[] args) {
		
		//index가 따로 없고, key와 value로 구성되어 있다.
		HashMap <Integer,String> hash = new HashMap <Integer,String>();
		
		//입력
		hash.put(0, "test0");
		hash.put(1, "test1");
		hash.put(2, "test2");
		System.out.println(hash);
		
		//호출
		System.out.println("hash.get(0) : "+hash.get(0));
		
		//삭제
		hash.remove(0);
		System.out.println("remove(0) : "+hash);
		
		//전부삭제
		hash.clear();
		System.out.println("clear : "+hash);
		
		//iterator라는 개념도 있다.

	}
}
