package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2156_포도주시식 {

	static int N;
	static int[] glasses;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		glasses = new int[N];
		dp = new int[N][2];
		for (int i = 0; i < N; i++) {
			glasses[i] = Integer.parseInt(bf.readLine());
		}

		dp[0][0] = glasses[0];
		dp[0][1] = glasses[0];
		dp[1][0] = glasses[1] + dp[0][1];
		dp[1][1] = glasses[1];
		for (int i = 2; i < N; i++) {
			dp[i][0] = dp[i - 1][1] + glasses[i];
			dp[i][1] = dp[i - 2][0] + glasses[i];
		}
		
		
	}

}
