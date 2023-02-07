package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_6109 {
	public static int N;
	public static String dir;
	public static int[][] tiles;

	public static void moveUp() {
		for (int col = 0; col < N; col++) {
			for (int row = 0; row < N; row += 2) {
				
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		// up, down, right, left
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		// 테스트 케이스
		for (int test_case = 1; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			// N과 방향 입력 받기
			N = Integer.parseInt(st.nextToken());
			dir = st.nextToken();
			// 타일 배열 초기화
			tiles = new int[N][N];
			// 숫자 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					tiles[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 이동
			move();
			// 출력

		}

	}

}