package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14501 { // 퇴사

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		int[][] schedule = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 2; j++) {
				schedule[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] maxProfit = new int[N];
		for (int i = 0; i < N; i++) {
			int after = schedule[i][0] + i;
			if (after < N) {
				maxProfit[after] = Math.max(maxProfit[after], maxProfit[i] + schedule[i][1]);
			}
		}
		Arrays.sort(maxProfit);
		System.out.println(maxProfit[N - 1]);
	}

}
