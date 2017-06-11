package test1;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		TextParse textParse = new TextParse();
		Map<Integer, Integer> result = textParse.result("imap");
		System.out.println("검색 문자 위치 : "+ result);
		System.out.println("검색 문자 갯수 : "+ result.size());
	}

}
