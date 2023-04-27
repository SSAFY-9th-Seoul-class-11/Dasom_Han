package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int start, end, cost;

	public Edge(int start, int end, int cost) {
		super();
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}

}

public class Main_1647_도시분할계획 {

	static int N, M, max, res;
	static int[] parent;
	static PriorityQueue<Edge> pq;

	public static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		parent[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<Edge>(); // 우선순위 큐
		parent = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(s, e, c));
		}

		// make set
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		int cnt = 0;
		// 크루스칼
		// 노드 V개라면 V - 1개를 거쳐야, 즉 간선은 V - 2개일 때 끝!
		while (cnt != N - 2) {
			Edge edge = pq.poll();
			int s = edge.start;
			int e = edge.end;
			int c = edge.cost;

			if (union(s, e)) {
				res += c;
				cnt++;
			}
		}

		System.out.println(res);

	}

}
