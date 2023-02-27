package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17070 { // 파이프 옮기기 1

	static int N, res;
	static int[][] home;
	// 파이프 끝점이 가로로 이동하면 방향 변수를 0, 세로로 이동하면 1, 대각선으로 이동하면 2로 한다
	static int[][] direction = { { 0, 1, 0 }, { 1, 1, 2 }, { 1, 0, 1 } };

	private static boolean isDiagonal(int x, int y) {
		if (home[x - 1][y] == 1 || home[x][y - 1] == 1)
			return false;
		return true;
	}

	private static void dfs(int x, int y, int currDir) {

		if (x == N - 1 && y == N - 1) {
			res++;
			return;
		}

		if (currDir == 0) { // 파이프 방향이 가로라면
			for (int d = 0; d <= 1; d++) {
				int nx = x + direction[d][0];
				int ny = y + direction[d][1];
				int nextDir = direction[d][2];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || home[nx][ny] == 1)
					continue;
				if (d == 1 && !isDiagonal(nx, ny)) // 대각선으로 가려면 세 칸이 모두 비어있어야 함
					continue;
				dfs(nx, ny, nextDir);
			}
		}
		if (currDir == 1) { // 파이프 방향이 세로라면
			for (int d = 1; d <= 2; d++) {
				int nx = x + direction[d][0];
				int ny = y + direction[d][1];
				int nextDir = direction[d][2];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || home[nx][ny] == 1)
					continue;
				if (d == 1 && !isDiagonal(nx, ny)) 
					continue;
				dfs(nx, ny, nextDir);
			}
		}
		if (currDir == 2) { // 파이프 방향이 대각선이라면
			for (int d = 0; d <= 2; d++) {
				int nx = x + direction[d][0];
				int ny = y + direction[d][1];
				int nextDir = direction[d][2];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || home[nx][ny] == 1)
					continue;
				if (d == 1 && !isDiagonal(nx, ny)) 
					continue;
				dfs(nx, ny, nextDir);
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		home = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0); // 파이프의 끝점

		System.out.println(res);
	}
}
