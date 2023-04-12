package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기_한다솜 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(bf.readLine()); // 도시의 개수
		int M = Integer.parseInt(bf.readLine()); // 버스의 개수
		int[][] adj = new int[N + 1][N + 1]; // 도시 사이 이동 비용
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[start][end] = cost;
		}
		st = new StringTokenizer(bf.readLine());
		final int START = Integer.parseInt(st.nextToken());
		final int END = Integer.parseInt(st.nextToken());
		final int INF = Integer.MAX_VALUE;
		
		int[] D = new int[N + 1]; // 시작 정점에서의 거리 저장 배열
		for (int i = 1; i <= N; i++) {
			D[i] = INF;
		}
		boolean[] visited = new boolean[N + 1]; // 방문 도시 처리 배열
		visited[START] = true;
		
		for (int v = 1; v <= N; v++) {
			D[v] = adj[START][v];
		}
		
	}

}
