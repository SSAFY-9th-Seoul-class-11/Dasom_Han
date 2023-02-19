package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Wire implements Comparable<Wire> {
	int start;
	int end;

	public Wire(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Wire o) {
		return this.start - o.start;
	}

}

public class boj_2565 { // 전깃줄

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		Wire[] wires = new Wire[N];
		int[] dp = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			wires[i] = new Wire(start, end);
		}

		Arrays.sort(wires);

		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (wires[i].end > wires[j].end) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(N - max);
	}

}

// 철거되어야 할 전선의 최소 개수라 하면, 거꾸로 전체 전선의 개수에서 최대한 겹치지 않게 설치 가능한 개수를 구하여 빼면
// 즉 (전체 전선 개수 - 설치 가능 개수) = 철거 개수 가 되지 않을까?
