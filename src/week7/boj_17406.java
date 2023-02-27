package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17406 { // 배열 돌리기 4

	static int N, M, K;
	static int[][] arr;
	static int[][] calc;
	static boolean[] isSelected;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int min;

	private static void swap(int x, int y) {
		int[] temp = calc[x];
		calc[x] = calc[y];
		calc[y] = temp;
	}

	private static void getSeq(int curr) {
		if (curr == K - 1) {
			int[][] arr2 = new int[N][M];
			for (int r = 0; r < N; r++) {
				System.arraycopy(arr[r], 0, arr2[r], 0, M);
			}
			for (int j = 0; j < K; j++) {
				arr2 = spin(j, arr2);
			}
			min = Math.min(min, getMin(arr2)); // 모두 다 연산 후 배열의 값의 최소 업데이트
			return;
		}

		for (int i = curr; i < K; i++) {
			swap(curr, i);
			getSeq(curr + 1);
			swap(i, curr);
		}
	}

	private static int getMin(int[][] arr) { // "배열의 값" 구하기

		int rowMin = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += arr[i][j];
			}
			rowMin = Math.min(rowMin, sum);
		}

		return rowMin;
	}

	private static int[][] spin(int calcIdx, int[][] origin) { // 회전

		int[][] arr3 = new int[N][M];
		for (int r = 0; r < N; r++) {
			System.arraycopy(origin[r], 0, arr3[r], 0, M);
		}
		int r = calc[calcIdx][0] - 1;
		int c = calc[calcIdx][1] - 1;
		int s = calc[calcIdx][2];
		int startX = r - s;
		int startY = c - s;
		int endX = r + s;
		int endY = c + s;

		for (int i = 0; i < s; i++) {
			int x = startX + i;
			int y = startY + i;
			for (int d = 0; d < 4; d++) {
				while (true) {
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];
					if (nx < startX + i || nx > endX - i || ny < startY + i || ny > endY - i) {
						break;
					}
					arr3[nx][ny] = origin[x][y];
					x = nx;
					y = ny;
				}
			}
		}
		return arr3;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		calc = new int[K][3]; // 연산 종류 배열
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				calc[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// ----------입력----------

		getSeq(0);
		System.out.println(min);
	}

}
