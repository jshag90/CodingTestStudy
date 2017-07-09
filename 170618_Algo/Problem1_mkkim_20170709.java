package algorithm_20170709;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem1_mkkim_20170709 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = strState("{,(,),}");
		if (result == 1) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	
	
	public static int strState(String str) {
		int resultState = 1;
		Map<String, String> strMap = new HashMap<String, String>();
	
		String[] strList = str.split(",");
		if (strList.length > 0 && (strList.length % 2) == 0 &&strList != null) {
			Stack strStack = new Stack();
			for (String val : strList) {
				if ("[".equals(val) || "{".equals(val) || "(".equals(val)) {
					strStack.push(val);
				}
				else if("]".equals(val)) {
					if (!"[".equals(strStack.pop())){
						return 0;
					}
				}
				else if("}".equals(val)) {
					if (!"{".equals(strStack.pop())){
						return 0;
					}
				}
				else if(")".equals(val)) {
					if (!"(".equals(strStack.pop())){
						return 0;
					}
				}
				
			}
			
		}
		
	
		
		return resultState;
	}
}
