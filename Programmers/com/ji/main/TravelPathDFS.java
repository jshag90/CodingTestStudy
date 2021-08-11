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

	
	public static void main(String[] args) {
//
		String[] result1 = solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } });
		for(String res : result1)
			System.out.print(res+" ");
		System.out.println();
		String[] result2 = solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } });
		for(String res : result2)
			System.out.print(res+" ");
//		System.out.println(solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } }));

	}
	
	private static List<String> DFSvisitArr = new ArrayList<>();
	public static String[] solution(String[][] tickets) {
		String[] answer = {};
		
		List<Integer> icnList = new ArrayList<>();
		for(int i=0; i<tickets.length; i++) {
			if( tickets[i][0] == "ICN") 
				icnList.add(i);
		}
		
		for(int j=0; j < icnList.size(); j++) {
			DFSvisitArr = new ArrayList<String>();
			DFSvisitArr.add("ICN");
			boolean[] visted = new boolean[tickets.length];
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
