package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11403 { // 경로 찾기

	static int[][] adjMatrix;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		adjMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 플로이드-워셜 알고리즘
		// i-k, k-j가 존재하면 i-j는 존재한다
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (adjMatrix[i][k] == 1 && adjMatrix[k][j] == 1)
						adjMatrix[i][j] = 1;
				}
			}
		}
		
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(adjMatrix[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
