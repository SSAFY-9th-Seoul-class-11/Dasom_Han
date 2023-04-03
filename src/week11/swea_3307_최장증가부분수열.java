package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3307_최장증가부분수열 {

	static int N;
	static int[] arr, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(bf.readLine());
			arr = new int[N];
			dp = new int[N];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int LIS = 0; // 길이
			for (int i = 0; i < N; i++) {
				int idx = Arrays.binarySearch(dp, 0, LIS, arr[i]);
				idx = Math.abs(idx) - 1;
				dp[idx] = arr[i];
				if (idx == LIS)
					LIS++;
			}
			System.out.println("#" + test_case + " " + LIS);
		}
	}

}
