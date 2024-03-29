package week14;

import java.util.Scanner;

public class Main_15652_N과M4_한다솜 {

	static int N, M;
	static int[] arr;
	static StringBuilder sb;

	public static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			arr[cnt] = i;
			comb(cnt + 1, i);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		comb(0, 1);
		System.out.println(sb.toString());
	}

}
