package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class swea_2819 {

	private static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private static StringBuilder sb;
	private static Set<String> set;
	private static int[][] board;

	private static void dfs(int cnt, int x, int y, String str) {
		// 7개가 되면 set에 추가
		if (cnt == 6) {
			set.add(str);
			return;
		}
		// 동서남북 돌면서 dfs 재귀
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
				continue;
			// 탐색 횟수는 +1, str에는 숫자 붙이기
			dfs(cnt + 1, nx, ny, str + board[nx][ny]);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 2차원 배열에 수 저장
			board = new int[4][4];
			// 문자열 저장할 set
			set = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 4; j++) {
					board[i][j] = st.nextToken().charAt(0);
				}
			}
			// dfs 시작
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(0, i, j, "" + board[i][j]);
				}
			}
			System.out.println("#" + test_case + " " + set.size());
		}
	}
}
