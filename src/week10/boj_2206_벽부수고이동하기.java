package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2206_벽부수고이동하기 {

	static int N, M, res;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	private static void bfs(int startX, int startY) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { startX, startY });
		int x = 0;
		int y = 0;
		while (!que.isEmpty()) {
			int len = que.size();
			loop: for (int i = 0; i < len; i++) {
				int[] temp = que.poll();
				x = temp[0];
				y = temp[1];
				for (int d = 0; d < 4; d++) {
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					if (map[x][y] == 1 && map[nx][ny] == 1) // 벽을 두번 만난 경우
						continue;
					if (nx == N - 1 && ny == M - 1) {// 끝까지 간 경우
						x = nx;
						y = ny;
						break loop;
					}
					if (map[x][y] == 0 && map[nx][ny] == 0) {
						map[nx][ny] = map[x][y] - 1;
					}
					que.offer(new int[] { nx, ny }); // 벽이 없거나 1번 부순 경우
				}
			}
			res++; // 최단 경로
		}
		if (x != N - 1 && y != M - 1)
			res = -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}

		bfs(0, 0);
		System.out.println(res);
	}
}
