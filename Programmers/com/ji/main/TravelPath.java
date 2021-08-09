package com.ji.main;

/**
 * 여행 경로
 * 
 * @author ji
 *
 */
public class TravelPath {

	public static void main(String[] args) {
		
		System.out.println(solution(new String[][]{{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}}));
		System.out.println(solution(new String[][]{{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}}));

	}

	public static String[] solution(String[][] tickets) {
		String[] answer = {};
		return answer;
	}
}
