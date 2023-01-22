package week2;

import java.util.Scanner;

public class swea_2806 {

	static int res;
	static int N;

	public static boolean isPromising(int[] q, int row) {
		for (int i = 0; i < row; i++) {
			if (q[row] == q[i] || Math.abs(q[row] - q[i]) == row - i)
				return false;
		}
		return true;
	}

	public static void dfs(int[] q, int row) {
		if (row == N)
			res++;
		else {
			for (int i = 0; i < N; i++) {
				q[row] = i;
				if (isPromising(q, row))
					dfs(q, row + 1);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			int[] q = new int[N];
			res = 0;
			dfs(q, 0);
			System.out.println("#" + test_case + " " + res);
		}
	}

}
