package com.ji.study;

public class RecommNewIdFail {

	public static void main(String[] args) {

	}

	public static String solution(String new_id) {
		String answer = "";

		new_id = parseToLowerCase(new_id);
		new_id = removeSpecialChar(new_id);
		new_id = replaceComma(new_id);
		new_id = removeFirstComma(new_id);
		new_id = removeBlank(new_id);
		new_id = removeLengthOver(new_id);
		new_id = removeLengthLow(new_id);
		answer = new_id;
		
		return answer;
	}

	public static String parseToLowerCase(String newId) {
		return newId.toLowerCase();
	}

	public static String removeSpecialChar(String newId) {
		String regex = "[0-9]*$|[a-z]*$|[-]|[_]|[.]";
		String filterStr = "";
		for (int i = 0; i < newId.length(); i++) {
			String charStr = newId.substring(i, i + 1);
			if (charStr.matches(regex)) {
				filterStr += charStr;
			}
		}
		return filterStr;
	}

	public static String replaceComma(String newId) {
		return newId.replace("...", ".").replace("..", ".");
	}

	public static String removeFirstComma(String newId) {
		if (newId.substring(0, 1).equals("."))
			newId = newId.substring(1, newId.length());
		
		if (!newId.equals("") &&newId.substring(newId.length()-1).equals("."))
			newId = newId.substring(0, newId.length() - 1);
			
		return newId;
	}

	public static String removeBlank(String newId) {
		newId = newId.replace(" ", "");
		if(newId.equals(""))
			newId+="a";
		return newId;
	}

	public static String removeLengthOver(String newId) {
		
		if (newId.length() > 15) {
			String removeNewId = newId.substring(0, 15);
			return removeFirstComma(removeNewId);
		}else {
			return newId;
		}
		
	}

	public static String removeLengthLow(String newId) {

		if (newId.length() <= 2) {
			String lastChar = newId.substring(newId.length() - 1, newId.length());
			while (newId.length() < 3) 
				newId += lastChar;
		}

		return newId;
	}

}
