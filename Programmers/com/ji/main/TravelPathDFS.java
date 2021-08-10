package com.ji.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 여행 경로
 * 
 * @author ji
 *
 */
public class TravelPathDFS {

	private static List<String> DFSvisitArr = new ArrayList<>();
	
	public static void main(String[] args) {
//
//		String[] result = solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } });
		String[] result = solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } });
		for(String res : result)
			System.out.print(res+" ");
//		System.out.println(solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } }));

	}
	
	

	public static String[] solution(String[][] tickets) {
		String[] answer = {};
		
		int row = tickets.length;
		
		List<Integer> icnList = new ArrayList<>();
		for(int i=0; i<tickets.length; i++) {
			if( tickets[i][0] == "ICN") 
				icnList.add(i);
		}
		
		for(int j=0; j < icnList.size(); j++) {
			DFSvisitArr = new ArrayList<String>();
			DFSvisitArr.add("ICN");
			boolean[] visted = new boolean[row];
			for(int i=0; i<tickets.length; i++) {
				if(visted[i] == false && icnList.get(j) == i) {
					dfs(i,visted,tickets, tickets[i][1]);
				}
			}
		}
		
		answer = DFSvisitArr.toArray(answer);
		return answer;
	}
	
	public static void dfs(int ticketIdx, boolean[] visted, String[][] tickets, String nextNode) {
		visted[ticketIdx] = true;
		DFSvisitArr.add(nextNode);
		for(int i=0; i<tickets.length; i++) {
			if(visted[i] == false && tickets[i][0] == nextNode) {
				dfs(i, visted, tickets, tickets[i][1] );
			}
		}
	}
	

}
