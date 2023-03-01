package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17472 {

	static int[][] map;
	static boolean[][] visited;
	static int N, M, island;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	
	private static void findPath() {
		
	}

	private static void findIsland(int startX, int startY) { // 섬찾기 함수

		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { startX, startY });
		while (!que.isEmpty()) {
			int[] start = que.poll();
			int x = start[0];
			int y = start[1];
			visited[x][y] = true;
			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
					continue;
				if (map[nx][ny] == 1) {
					map[nx][ny] = island;
					visited[nx][ny] = true;
					que.offer(new int[] {nx, ny});
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// --------입력---------
		
		island = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					findIsland(i, j);
					island++;
				}
			}
		}
		// -------섬찾기-------
		
		
		//-------가능한 모든 길찾기--------

	}

}
