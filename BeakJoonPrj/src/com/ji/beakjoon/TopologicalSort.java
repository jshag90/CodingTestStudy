package com.ji.beakjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {
	    static int N; // 그래?�� ?��?��?�� ?��
	    static int M; // 간선?�� ?��

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        N = scanner.nextInt();
	        M = scanner.nextInt();

	        int[] cntOfLink = new int[N + 1]; // 간선?�� ?��?�� ???�� 배열

	        // �?중치�? ?��?�� 그래?��(?��?�� 리스?�� ?��?��)
	        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	        for (int i = 0; i < N + 1; i++) {
	            graph.add(new ArrayList<Integer>());
	        }
	        // ?��방향 ?���? ?��?��
	        for (int i = 0; i < M; i++) {
	            int v1 = scanner.nextInt();
	            int v2 = scanner.nextInt();
	            graph.get(v1).add(v2);
	            cntOfLink[v2]++; // ?��?�� ?��?��?�� ???�� 간선?�� ?�� 증�?
	        }

	        // ?��?�� ?��?�� (A B: A�? B?��?�� ?��?��. A�? ?��?��)
	        topologicalSort(graph, cntOfLink);
	    }

	    /**
	     * ?��?�� ?��?��
	     */
	    static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] cntOfLink) {
	        Queue<Integer> queue = new LinkedList();

	        // 초기: ?��?�� ?��?��?�� �?�?�? ?��?�� ?��?��?�� ?��?�� ?��?��
	        for (int i = 1; i < N + 1; i++) {
	            if (cntOfLink[i] == 0) { // ?��?�� ?��?��?�� 간선?�� ?���? 0?���?
	                queue.add(i);
	            }
	        }

	        // ?��?��?�� ?�� 만큼 반복
	        for (int i = 0; i < N; i++) {
	            int v = queue.remove(); // 1. ?��?��?�� ?��?�� 추출
	            System.out.print(v + " "); // ?��?�� 출력

	            // 2. ?��?�� ?��?���? ?��결된 모든 ?��?��?�� ???��
	            for (int nextV : graph.get(v)) {
	                cntOfLink[nextV]--; // 2-1. 간선?�� ?�� 감소

	                // 2-2. ?��?�� ?��?��?�� �?�?�? ?��?�� ?��?��?�� ?��?�� ?��?��
	                if (cntOfLink[nextV] == 0) { // ?��?�� ?��?��?�� 간선?�� ?���? 0?���?
	                    queue.add(nextV);
	                }
	            }
	        }
	    }
}
