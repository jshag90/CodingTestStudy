package com.ji.beakjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {
	    static int N; // ê·¸ë˜?”„ ? •? ?˜ ?ˆ˜
	    static int M; // ê°„ì„ ?˜ ?ˆ˜

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        N = scanner.nextInt();
	        M = scanner.nextInt();

	        int[] cntOfLink = new int[N + 1]; // ê°„ì„ ?˜ ?ˆ˜?— ???•œ ë°°ì—´

	        // ê°?ì¤‘ì¹˜ê°? ?—†?Š” ê·¸ë˜?”„(?¸? ‘ ë¦¬ìŠ¤?Š¸ ?´?š©)
	        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	        for (int i = 0; i < N + 1; i++) {
	            graph.add(new ArrayList<Integer>());
	        }
	        // ?‹¨ë°©í–¥ ?—°ê²? ?„¤? •
	        for (int i = 0; i < M; i++) {
	            int v1 = scanner.nextInt();
	            int v2 = scanner.nextInt();
	            graph.get(v1).add(v2);
	            cntOfLink[v2]++; // ?›„?–‰ ? •? ?— ???•œ ê°„ì„ ?˜ ?ˆ˜ ì¦ê?
	        }

	        // ?œ„?ƒ ? •? ¬ (A B: Aê°? B?•?— ?„ ?‹¤. Aê°? ?„ ?–‰)
	        topologicalSort(graph, cntOfLink);
	    }

	    /**
	     * ?œ„?ƒ ? •? ¬
	     */
	    static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] cntOfLink) {
	        Queue<Integer> queue = new LinkedList();

	        // ì´ˆê¸°: ?„ ?–‰ ? •? ?„ ê°?ì§?ì§? ?•Š?Š” ? •? ?„ ??— ?‚½?…
	        for (int i = 1; i < N + 1; i++) {
	            if (cntOfLink[i] == 0) { // ?•´?‹¹ ? •? ?˜ ê°„ì„ ?˜ ?ˆ˜ê°? 0?´ë©?
	                queue.add(i);
	            }
	        }

	        // ? •? ?˜ ?ˆ˜ ë§Œí¼ ë°˜ë³µ
	        for (int i = 0; i < N; i++) {
	            int v = queue.remove(); // 1. ??—?„œ ? •?  ì¶”ì¶œ
	            System.out.print(v + " "); // ? •?  ì¶œë ¥

	            // 2. ?•´?‹¹ ? •? ê³? ?—°ê²°ëœ ëª¨ë“  ? •? ?— ???•´
	            for (int nextV : graph.get(v)) {
	                cntOfLink[nextV]--; // 2-1. ê°„ì„ ?˜ ?ˆ˜ ê°ì†Œ

	                // 2-2. ?„ ?–‰ ? •? ?„ ê°?ì§?ì§? ?•Š?Š” ? •? ?„ ??— ?‚½?…
	                if (cntOfLink[nextV] == 0) { // ?•´?‹¹ ? •? ?˜ ê°„ì„ ?˜ ?ˆ˜ê°? 0?´ë©?
	                    queue.add(nextV);
	                }
	            }
	        }
	    }
}
