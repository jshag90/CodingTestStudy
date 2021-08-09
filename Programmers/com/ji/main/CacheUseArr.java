package com.ji.main;

public class CacheUseArr {

	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		String[] cache = new String[cacheSize];

		if (cacheSize == 0)
			return cities.length * 5;

		for (String city : cities) {
			int pos = -1;
			for (int i = 0; i < cacheSize; i++) {
				if (city.equalsIgnoreCase(cache[i])) { //cache안에 city가 들어 있다면
					pos = i; // hit  index 이동
				}
			}

			if (pos == -1) { // miss
				
				for (int j = cache.length - 1; j >= 1; j--) {
					cache[j] = cache[j - 1];
				}
				answer = answer + 5;
				
			} else {// hit
				
				for (int j = pos; j >= 1; j--) {
					cache[j] = cache[j - 1];
				}
				answer++;
				
			}
			//새로 들어온것을 맨 위로
			cache[0] = city;
		}

		return answer;
		
	}
	
}
