package week14;

import java.util.Scanner;

public class Main_15652_N과M4_한다솜 {

	static int N, M;
	static int[] arr;

	public static void comb(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}

		for (int i = 1; i <= N; i++) {
			arr[cnt] = i;
			comb(cnt + 1);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		comb(0);
	}

}
