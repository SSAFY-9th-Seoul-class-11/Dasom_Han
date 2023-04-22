package week14;

import java.util.Scanner;

public class Main_15651_N과M3_한다솜 {

	static int N, M;
	static int[] arr;
	static StringBuilder sb;

	public static void comb(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			arr[cnt] = i;
			comb(cnt + 1);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		comb(0);
		System.out.println(sb.toString());
	}

}
