package com.sundayalgo.threeday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BracketCheck {

	public static List<String> logList = new ArrayList<String>();
	
	public static void main(String[] args) {
		String inputBracket = "{,],[,},{,)";
		
		Map<String,String> bracketMap = new HashMap<String,String>();
		
		
		
		String[] bracketSplit = inputBracket.split(",");
		
		for(int i=1; i<bracketSplit.length; i++){	
			bracketMap.put(bracketSplit[0], bracketSplit[i]);
			bracketCheck(bracketMap);
		}
		
		for(int i=0; i<logList.size(); i++){

			System.out.println(logList.get(i));
			
		}
	}

	private static int bracketCheck(Map<String, String> bracketMap) {
		
		int result = 0;
		String logStr = "";
		
		  Iterator<String> iterator = bracketMap.keySet().iterator();
		  
		for(int i=0; i<bracketMap.size(); i++){
			   String key = (String) iterator.next();
			   String val = bracketMap.get(key);
			   
			   logStr = " '"+key+"' -> '"+val+"' ";
		}
		
		if(bracketMap.containsKey("{")){
			if(bracketMap.get("{").equals("}")){
				result = 0;
				logStr += "�Ǻ� : " + result;
			}else{
				result =  1;
				logStr += "�Ǻ� : " + result;
			}
		}else if(bracketMap.containsKey("(")){
			if(bracketMap.get("(").equals(")")){
				result = 0;
				logStr += "�Ǻ� : " + result;
			}else{
				result =  1;
				logStr += "�Ǻ� : " + result;
			}
			
		}else if(bracketMap.containsKey("[")){
			if(bracketMap.get("[").equals("]")){
				result = 0;
				logStr += "�Ǻ� : " + result;
			}else{
				result =  1;
				logStr += "�Ǻ� : " + result;
			}
			
		}
		
		   logList.add(logStr);
		
		return result;
	}
}
