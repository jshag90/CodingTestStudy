package test1;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		TextParse textParse = new TextParse();
		Map<Integer, Integer> result = textParse.result("imap");
		System.out.println("�˻� ���� ��ġ : "+ result);
		System.out.println("�˻� ���� ���� : "+ result.size());
	}

}
