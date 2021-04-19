package com.ji.beakjoon;

public class BellmanFordGraph {
	// ê·¸ë˜?”„?˜ ê°?ì¤‘ì¹˜ë¥? ?‚˜???‚´?Š” ?´?˜?Š¤
	class Edge {
		int src, dest, weight;

		Edge() {
			src = dest = weight = 0;
		}
	};

	int V, E;
	Edge edge[];

	// V, Eê°? ?ˆ?Š” ê·¸ë˜?”„ ?ƒ?„±
	BellmanFordGraph(int v, int e) {
		// TODO Auto-generated constructor stub
		V = v;
		E = e;
		edge = new Edge[e];
		for (int i = 0; i < e; ++i) {
			edge[i] = new Edge();
		}
	}

	// ë²¨ë§Œ?¬?“œ ?•Œê³ ë¦¬ì¦˜ì„ ?´?š©?•˜?—¬ src?—?„œ ?‹¤ë¥? ? •? ?“¤ê¹Œì??˜ ìµœë‹¨ê±°ë¦¬ë¥? ì°¾ëŠ” ë©”ì¸ ê¸°ëŠ¥
	// ?Œ?˜ ë¬´ê²Œ ì£¼ê¸° ê°ì?
	void BellmanFord(BellmanFordGraph graph, int src) {
		int V = graph.V, E = graph.E;
		int dist[] = new int[V];
		// 1?‹¨ê³? : src?—?„œ ?‹¤ë¥? ? •? ?œ¼ë¡? ëª¨ë“  ? •?  ì´ˆê¸°?™”
		for (int i = 0; i < V; ++i) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		// 2?‹¨ê³? : ëª¨ë“  edge|V|-1?šŒ,
		// src?—?„œ ?‹¤ë¥? ? •? ?“¤ê¹Œì??˜ ê°„ë‹¨?•œ ìµœë‹¨ê²½ë¡œ?Š” |V|-1 ?„ ?„ ê°?ì§? ?ˆ˜ ?ˆ?‹¤.
		for (int i = 1; i < V; ++i) {
			for (int j = 0; j < E; ++j) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;
				}
			}
		}
		// 3?‹¨ê³? : ë¹? ê°?ì¤‘ì¹˜ ?‚¬?´?´ ? ê²?
		// ë§Œì•½ ?” ì§§ì? ê¸¸ì„ ê°?ì§„ë‹¤ë©? ?ˆœ?™˜?´ ?´ë£¨ì–´ì§„ë‹¤
		for (int j = 0; j < E; ++j) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;
			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
				System.out.println("Bellman-Ford Graph contains negative weight cycle");
			}
		}
		printArr(dist, V);
	}

	// ë°°ì—´ ì¶œë ¥
	void printArr(int dist[], int V) {
		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; ++i) {
			System.out.println(i + "\t\t" + dist[i]);
		}
	}

	public static void main(String[] args) {

		int V = 5; // ê·¸ë˜?”„?˜ ? ?˜ ?ˆ˜
		int E = 8; // ê·¸ë˜?”„?˜ ?„ ?˜ ?ˆ˜

		BellmanFordGraph graph = new BellmanFordGraph(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = -1;

		// add edge 0-2
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 4;

		// add edge 1-2
		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].weight = 3;

		// add edge 1-3
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 2;

		// add edge 1-4
		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].weight = 2;

		// add edge 3-2
		graph.edge[5].src = 3;
		graph.edge[5].dest = 2;
		graph.edge[5].weight = 5;

		// add edge 3-1
		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].weight = 1;

		// add edge 4-3
		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].weight = -3;

		graph.BellmanFord(graph, 0);
	}

}