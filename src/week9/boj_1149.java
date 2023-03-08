package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1149 { // RGB거리

	static int N, min;
	static int[][] costs;

	private static void paint(int cnt, int total, int lastColor) {
		if (total >= min) { // 중간에 비용이 현재 최소값보다 크다면 이 경우는 리턴
			return;
		}

		if (cnt == N) { // 끝까지 칠할 수 있었다면 최소값 업데이트
			min = Math.min(min, total);
			return;
		}

		for (int i = 0; i < 3; i++) {

			if (lastColor != i) { // 직전 집 색과 다를 경우에만
				paint(cnt + 1, total + costs[cnt][i], i);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		costs = new int[N][3];
		min = Integer.MAX_VALUE;
		for (int house = 0; house < N; house++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int color = 0; color < 3; color++) {
				costs[house][color] = Integer.parseInt(st.nextToken());
			}
		}

		paint(0, 0, -1); // 맨처음 집 전의 색을 -1로 해서 겹치지 않게

		System.out.println(min);
	}

}
