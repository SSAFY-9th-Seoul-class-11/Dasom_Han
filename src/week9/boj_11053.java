package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11053 { // 가장 긴 증가하는 부분 수열

	static int N, res;
	static int[] seq, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		seq = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		// 만약 다음칸 숫자가 이전칸 숫자보다 크면 dp배열 값 업데이트
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (seq[j] > seq[i]) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
				}
			}
		}

		// 정렬 후 가장 큰 값 = 가장 긴 증가하는 부분 수열의 길이
		Arrays.sort(dp);
		System.out.println(dp[N - 1]);
	}

}
