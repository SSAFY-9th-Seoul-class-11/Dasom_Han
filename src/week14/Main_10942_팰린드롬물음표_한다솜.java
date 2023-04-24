package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10942_팰린드롬물음표_한다솜 {


	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[N + 1];
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// dp 배열 전처리
		for (int i = 1; i <= N; i++) {
			dp[i][i] = 1; // 자기자신은 팰린드롬
		}
		for (int i = 1; i <= N - 1; i++) {
			if (arr[i] == arr[i + 1]) // 길이가 2일 때 바로 옆 수와 자신이 같다면 팰린드롬
				dp[i][i + 1] = 1;
		}
		// 길이가 3이상일 때 끝 수와 자신이 같고, 그 사이 수가 팰린드롬이면 팰린드롬
		for (int i = 2; i < N; i++) {
			for (int j = 1; j <= N - i; j++) {
				if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1] == 1)
					dp[j][j + i] = 1;
			}
		}
		
//		for (int i = 1; i <= N - 2; i++) {
//			for (int j = 2; j <= N - i; j++) {
//				if (arr[i] == arr[i + j] && dp[i + 1][i + j - 1] == 1)
//					dp[i][i + j] = 1;
//			}
//		}

		int M = Integer.parseInt(bf.readLine());
		for (int q = 1; q <= M; q++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(dp[s][e] + "\n");
		}
		
		System.out.println(sb.toString());

	}

}
