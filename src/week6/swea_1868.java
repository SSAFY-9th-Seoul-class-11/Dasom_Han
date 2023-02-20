package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1868 { // 파핑파핑 지뢰찾기

	static int N;
	static char[][] bomb;
	static int click;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

	private static void findZero(int x, int y) {
		
		Queue<int[]> que = new ArrayDeque<int[]>();
		boolean isZero = true;
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) 
				continue;
			if (bomb[nx][ny] == '*') {
				isZero = false;
				break;
			}
			if (bomb[nx][ny] == '.') {
				que.offer(new int[] {nx, ny});
			}
		}
		if (!isZero && !que.isEmpty()) {
			bomb[x][y] = 'o';
			click++;
			bfs(que);
		}
	}
	
	private static void bfs(Queue<int[]> que) {

		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int x = temp[0];
			int y = temp[1];
			bomb[x][y] = 'o';

			for (int i = 0; i < 8; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) 
					continue;
				if (bomb[nx][ny] == '*') {
					break;
				}
				if (bomb[nx][ny] == '.') {
					que.offer(new int[] {nx, ny});
				}
			}
			
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(bf.readLine());
			bomb = new char[N][N];
			click = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				String temp = st.nextToken();
				for (int j = 0; j < N; j++) {
					bomb[i][j] = temp.charAt(j);
				}
			}
			
			// 0인 곳 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (bomb[i][j] == '.') {
						findZero(i, j);
					}
				}
			}
			
			// 나머지 부분
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (bomb[i][j] == '.') {
						click++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + click);
		}
	}

}
