package com.ji.main;

import java.util.ArrayList;
import java.util.List;

/**
 * 여행 경로
 * 
 * @author ji
 *
 */
public class TravelPathFail02 {

	public static void main(String[] args) {

//		String[] result1 = solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } });
//		for (String res : result1)
//			System.out.print(res + " ");
//		System.out.println();
		String[] result2 = solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" },
				{ "ATL", "ICN" }, { "ATL", "SFO" } });
		for (String res : result2)
			System.out.print(res + " ");
	}

	static boolean[] visted;
	static ArrayList<String> DFSvisitArr;
	
	public static String[] solution(String[][] tickets) {

		for (int i = 0; i < tickets.length; i++) {
			
			if (tickets[i][0] == "ICN") {
				DFSvisitArr = new ArrayList<String>();
				DFSvisitArr.add(tickets[i][0]);
				visted = new boolean[tickets.length];
				for (int k = 0; k < tickets.length; k++) {
					if (visted[k] == false && i == k) {
						visted[k] = true;
						dfs(k, visted, tickets, tickets[k][1], DFSvisitArr);
						visted[k] = false;
					}
				}
				
				System.out.println(DFSvisitArr);
			}
		}
		String[] result = new String[DFSvisitArr.size()];
		for(int i=0 ;i < DFSvisitArr.size(); i++)
			result[i] = DFSvisitArr.get(i);
		
		//ICN,ATL,ICN,SFO,ATL,SFO,  
		//ICN,ATL,SFO,ATL,ICN,SFO, <- 다음 경우의 수를 접근하지 못함
		//ICN,SFO,ATL,ICN,ATL,SFO,
		
		return result;
	}

	static void dfs(int ticketIdx, boolean[] visted, String[][] tickets, String nextNode, List<String> dfsList) {
		visted[ticketIdx] = true;
		dfsList.add(nextNode);
		for (int i = 0; i < tickets.length; i++) {
			if (visted[i] == false && tickets[i][0] == nextNode) {
				dfs(i, visted, tickets, tickets[i][1], dfsList);
				visted[ticketIdx] = true;
			}
		}
	}

}
