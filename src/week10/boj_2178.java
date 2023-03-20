package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178 { // 미로 탐색

	static int N, M;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	private static void bfs(int startX, int startY) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { startX, startY });
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int x = temp[0];
			int y = temp[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0)
					continue;    // 범위 벗어나거나 길이 아닌 경우 pass
				if (map[nx][ny] == 1) {  // 1인 경우
					map[nx][ny] = map[x][y] + 1;   // 이전 위치의 값 + 1 해주며 경로 길이 계산
					if (nx == N - 1 && ny == M - 1)   // 끝에 도달했으면 끝내기
						break;
					que.offer(new int[] { nx, ny });
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
		for (int i = 0; i < N; i++) {
			String temp = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		bfs(0, 0);
		System.out.println(map[N - 1][M - 1]);  // 도착지의 숫자 = 경로의 길이
	}

}
