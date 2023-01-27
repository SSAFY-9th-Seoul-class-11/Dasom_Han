package week3;

import java.util.Scanner;

public class swea_1215 {

	public static boolean isPalin(char[] arr) {
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			if (arr[i] != arr[N - 1 - i])
				return false;
		}
		return true;
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int res = 0;
			// char 배열로 입력 받기
			char[][] palin = new char[8][8];
			for (int i = 0; i < 8; i++) {
				palin[i] = sc.next().toCharArray();
			}
			// 수평
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - N + 1; j++) {
					char[] temp = new char[N];
					for (int k = 0; k < N; k++) {
						temp[k] = palin[i][j + k];
					}
					if (isPalin(temp))
						res++;
				}
			}
			// 수직
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - N + 1; j++) {
					char[] temp = new char[N];
					for (int k = 0; k < N; k++) {
						temp[k] = palin[j + k][i];
					}
					if (isPalin(temp))
						res++;
				}
			}
			// 결과 출력
			System.out.println("#" + test_case + " " + res);
		}
	}

}
