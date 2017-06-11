package test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextParse {
	private final String FILE_PATH = "D:/algorithm_workspace/algorithm_1.txt";
	private final String SPLIT_STR = "[:=_-[,]_]";
	public Map<Integer, Integer> result(String inputStr)  {
		Map<Integer, Integer> searchLocation = new HashMap<Integer, Integer>();
		BufferedReader in;
		try {
			
			in = new BufferedReader(new FileReader(FILE_PATH));
			String s;
			int lineCnt = 0;
			
			while ((s = in.readLine()) != null) {
		        if(s.indexOf(inputStr) > -1) {
		        	
		        	List<Integer> indexList = findIndex(s, inputStr);
		        	for (Integer index : indexList) {
		        		searchLocation.put(lineCnt, index);
		        		
					}
		        	
		        	
		        }
			
		        lineCnt++;
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	     
	    
		return searchLocation;
	}
	
	private List<Integer> findIndex(String s,String inputStr) {
		String[] sList = s.split(SPLIT_STR);
		List<Integer> resultList = new ArrayList<Integer>();
		for (int i = 0; i < sList.length; i++) {
			if(sList[i].indexOf(inputStr) > -1) {
				resultList.add(i);
			}
		}
		
		return resultList;	
	}
	
}
