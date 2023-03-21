package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2156_포도주시식 {

	static int N;
	static int[] glasses;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		glasses = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			glasses[i] = Integer.parseInt(bf.readLine());
		}

		dp[0] = glasses[0];

		for (int i = 1; i < N; i++) {
			if (i == 1) {
				dp[1] = dp[0] + glasses[1];
			} else if (i == 2) {
				dp[2] = Math.max(dp[1], Math.max(glasses[0] + glasses[2], glasses[1] + glasses[2]));
			} else {
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + glasses[i], dp[i - 3] + glasses[i - 1] + glasses[i]));
			}
		}

		System.out.println(dp[N - 1]);
		
		
	}

}
