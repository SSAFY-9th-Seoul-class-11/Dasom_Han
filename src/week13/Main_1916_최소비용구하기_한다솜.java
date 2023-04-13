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
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				adj[i][j] = -1;  // 비용이 0인 경우도 있으므로 초기화를 -1로 한다
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (adj[start][end] > -1)
				adj[start][end] = Math.min(adj[start][end], cost);  // 같은 노선이나 비용이 더 작게 들어오는 경우도 있다
			else 
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
		
		D[START] = 0; // 자기 자신까지의 거리 0
		
		int layover, dist;
		for (int cnt = 1; cnt <= N; cnt++) {  // 모든 정점을 돌면서..
			layover = 0;
			dist = INF;
			for (int v = 1; v <= N; v++) {
				if(!visited[v] && dist > D[v]) {  // 경유지로 처리되지 않은 정점 중 출발지와 가장 가까운 것
					layover = v;
					dist = D[v];
				}
			}
			if (layover == 0)  // 가장 가까운 정점이 없다면 탈출, 그러나 문제에선 이런 경우 제외
				break;
			
			visited[layover] = true;  // 경유지 방문
			
			if (layover == END)  // 경유지가 도착지라면 끝
				break;
			
			for (int v = 1; v <= N; v++) {
				// 경유지를 거쳤을 때 출발지-v 거리가 더 짧아진다면
				if (!visited[v] && adj[layover][v] > -1 && D[v] > dist + adj[layover][v]) {
					D[v] = dist + adj[layover][v];
				}
			}
		}
		System.out.println(D[END]);
		
	}

}
