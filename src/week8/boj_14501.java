package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14501 { // 퇴사

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] schedule = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 2; j++) {
				schedule[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// dp 테이블
		int[] maxProfit = new int[N + 1];
		for (int i = 0; i < N; i++) {
			int after = schedule[i][0] + i;
			if (after <= N) {
				maxProfit[after] = Math.max(maxProfit[after], maxProfit[i] + schedule[i][1]);
			}

			maxProfit[i + 1] = Math.max(maxProfit[i], maxProfit[i + 1]); // 다음날 업데이트 해줘야함!!!!
		}
		// 그 날 상담에서 걸리는 날짜만큼 뒤로 가서 돈을 더해주는데
		// 만약 이미 그 날짜의 돈이 더 크다면 유지, 아니면 업데이트

		System.out.println(maxProfit[N]); // 퇴사 다음날 들어오는 돈...
	}

}
