package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12865_평범한배낭 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());  // 물건 개수
		int K = Integer.parseInt(st.nextToken());  // 최대 무게
		
		int[] weights = new int[N + 1];  // 물건별 무게
		int[] values = new int[N + 1];  // 물건별 가치
		int[][] dp = new int[N + 1][K + 1];  // dp 배열
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}

		for (int n = 1; n <= N; n++) { // 물건
			for (int w = 1; w <= K; w++) { // 무게
				if (weights[n] > w) {
					dp[n][w] = dp[n - 1][w];
				} else {
					dp[n][w] = Math.max(dp[n - 1][w], values[n] + dp[n - 1][w - weights[n]]);
				}
			}
		}

		int max = 0;
		for (int n = 1; n <= N; n++) { // 물건
			for (int w = 1; w <= K; w++) { // 무게
				max = Math.max(max, dp[n][w]);
			}
		}

		System.out.println(max);
	}
}
