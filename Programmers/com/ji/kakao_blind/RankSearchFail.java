package com.ji.kakao_blind;

/**
 * 2021 KAKAO BLIND RECRUITMENT 3번 - 순위 검색
 * @author seonhak
 * @date 2021. 10. 8.
 */
public class RankSearchFail {

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200"
				, 
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" 
				};

		for (int result : solution(info, query))
			System.out.print(result + " ");

	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = {};
		answer = new int[query.length];

		int index = 0;
		for (String queryLine : query) {
			String[] queryInfoAnd = queryLine.split(" and ");
			String[] fScore = queryInfoAnd[3].split(" ");
			
			String lang = queryInfoAnd[0];
			String job = queryInfoAnd[1];
			String career = queryInfoAnd[2];
			String food = fScore[0];
			Integer score = Integer.parseInt(fScore[1]);

			int cnt = 0;
			for (String infoStr : info) {
				String[] infoArr = infoStr.split(" ");
				
				if (Integer.parseInt(infoArr[4]) >= score) {//코테 점수
					
					//효율성 테스트 통과 못함 !!!
					if ( 
							 infoArr[0].equals(lang.equals("-") ? infoArr[0] : lang )
						&& infoArr[1].equals(job.equals("-") ? infoArr[1] : job )
						&& infoArr[2].equals(career.equals("-") ? infoArr[2] : career ) 
						&& infoArr[3].equals(food.equals("-") ? infoArr[3] : food ) //선호 음식
					)
					{
						cnt++;
					}
					
				}
				
			}
			
			answer[index++] = cnt;

		}

		return answer;
	}

}
