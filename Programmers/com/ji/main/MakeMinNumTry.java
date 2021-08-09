package com.ji.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeMinNumTry {
	
	public static void main(String[] args) {
		int[] A = new int[] {1,2};
		int[] B = new int[] {3,4};
		System.out.println(solution(A, B));
	}

	public static int solution(int[] A, int[] B) {
		int answer = 0;

		List<Integer> sumList = new ArrayList<Integer>();
		
		List<int[]> AList = new ArrayList<int[]>();
		List<int[]> BList = new ArrayList<int[]>();

		permutation(A, 0, A.length, A.length, AList);
		permutation(B, 0, B.length, B.length, BList);

		for(int i=0 ; i < AList.size() ; i++) {
			int[] Aper = AList.get(i);
			
			for(int k=i; k < BList.size(); k++) {
				int[] Bper = BList.get(k);
			
				int sum = 0;
				for (int j = 0; j < Aper.length; j++) {
					sum = sum + (Aper[j] * Bper[j]);
				}
				sumList.add(sum);
				
			}
		}

		answer = Collections.min(sumList);
		return answer;
	}

	static void permutation(int[] arr, int depth, int n, int r, List<int[]> List) {
		if (depth == r) {
			 int[] perArr = new int[arr.length];
			 for (int i = 0; i < r; i++) {
		         perArr[i] = arr[i];
		     }
			 List.add(perArr);
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r, List);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}
	
}
