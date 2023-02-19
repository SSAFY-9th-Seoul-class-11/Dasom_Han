package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9465 { // 스티커

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(bf.readLine());
			int[][] sticker = new int[2][N + 1];  // N이 1인 경우를 위해
			int[][] dp = new int[2][N + 1];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 1; j <= N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// dp 테이블 초기화
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];

			// 직전 열에서 대각선 위치의 최대값 + 자기 점수 or 전전 열에서 대각선 위치의 최대값 + 자기 점수
			for (int j = 2; j <= N; j++) {
				dp[0][j] = Math.max(sticker[0][j] + dp[1][j - 1], sticker[0][j] + dp[1][j - 2]);
				dp[1][j] = Math.max(sticker[1][j] + dp[0][j - 1], sticker[1][j] + dp[0][j - 2]);
			}
			// 마지막 열에서의 최대값 중 더 큰 값
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}
	}

}
