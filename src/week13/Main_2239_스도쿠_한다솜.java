package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_스도쿠_한다솜 {

	static int[][] sdk;
	static StringBuilder sb;

	public static boolean row(int r, int n) {
		for (int j = 0; j < 9; j++) {
			if (sdk[r][j] == n)
				return false;
		}
		return true;
	}

	public static boolean col(int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (sdk[i][c] == n)
				return false;
		}
		return true;
	}

	public static boolean rect(int r, int c, int n) {
		int startX = (r / 3) * 3;
		int startY = (c / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (sdk[startX + i][startY + j] == n)
					return false;
			}
		}
		return true;
	}

	public static void fill(int x, int y) {

		if (y == 9) { // 행이 바뀔 때
			x += 1;
			y = 0;
		}
		if (x == 9) { // 끝까지 채웠으면 끝내기
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sdk[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		if (sdk[x][y] != 0) { // 칸이 0이 아니라면 다음칸으로
			fill(x, y + 1);
		} else {
			for (int n = 1; n <= 9; n++) {
				if (!row(x, n) || !col(y, n) || !rect(x, y, n))
					continue;
				sdk[x][y] = n;
				fill(x, y + 1);
				sdk[x][y] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		sdk = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String oneRow = bf.readLine();
			for (int j = 0; j < 9; j++) {
				sdk[i][j] = oneRow.charAt(j) - '0';
			}
		}

		fill(0, 0);

	}

}
