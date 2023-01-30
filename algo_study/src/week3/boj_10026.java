package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_10026 {
	static int N;
	static char[][] normalPaint;
	static char[][] weakPaint;
	static boolean[][] visited;
	static Stack<int[]> stk;
	static int normal;
	static int weak;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static char[] colors = { 'R', 'G', 'B' };
	// 적록색약 dfs
	public static void weakCheck(int X, int Y) {
		stk = new Stack<>();
		stk.push(new int[] { X, Y });
		while (!stk.isEmpty()) {
			int[] cur = stk.pop();
			int x = cur[0];
			int y = cur[1];
			char color = weakPaint[X][Y];
			for (int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
					continue;
				if (weakPaint[nx][ny] == color) {
					visited[nx][ny] = true;
					stk.push(new int[] {nx, ny});
				}
			}
		}
	}
	// 정상인 dfs
	public static void normalCheck(int X, int Y) {
		stk = new Stack<>();
		stk.push(new int[] { X, Y });
		while (!stk.isEmpty()) {
			int[] cur = stk.pop();
			int x = cur[0];
			int y = cur[1];
			char color = normalPaint[X][Y];
			for (int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
					continue;
				if (visited[nx][ny])
					continue;
				if (normalPaint[nx][ny] == color) {
					visited[nx][ny] = true;
					stk.push(new int[] {nx, ny});
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// N, 정상인 그림, 적록색약 그림, 방문처리 배열 생성
		N = Integer.parseInt(bf.readLine());
		normalPaint = new char[N][N];
		weakPaint = new char[N][N];
		visited = new boolean[N][N];
		// 적록색약이면 G가 들어왔을 때 R로 저장
		for (int i = 0; i < N; i++) {
			String temp = bf.readLine();
			for (int j = 0; j < N; j++) {
				normalPaint[i][j] = temp.charAt(j);
				if(temp.charAt(j) == 'G') {
					weakPaint[i][j] = 'R';
				} else {
					weakPaint[i][j] = temp.charAt(j);
				}

			}
		}
		// 정상인 dfs 수행
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int c = 0; c < 3; c++) {
					if (normalPaint[i][j] == colors[c] && !visited[i][j]) {
						normalCheck(i, j);
						normal++;
					}
				}
			}
		}
		// 방문처리 배열 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}		
		// 적록색약 dfs 수행
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int c = 0; c < 3; c++) {
					if (weakPaint[i][j] == colors[c] && !visited[i][j]) {
						weakCheck(i, j);
						weak++;
					}
				}
			}
		}
		
		System.out.println(normal + " " + weak);

	}

}