package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x, y, len;
	boolean isBroken;

	public Pos(int x, int y, int len, boolean isBroken) {
		super();
		this.x = x;
		this.y = y;
		this.len = len; // 지나간 거리의 길이
		this.isBroken = isBroken; // 벽 부순 여부
	}
}

public class boj_2206_벽부수고이동하기 {

	static int N, M, res;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

//	벽이 아니면
//		부신 벽이 여태까지 없었으면 -> visited[?][?][0] 방문 처리 + queue에 넣음
//		벽을 한번 부신 적이 있으면 -> visited[?][?][1] 방문 처리 + queue에 넣음
//	벽이면
//		한번도 벽을 부신 적이 없으면 부수고 -> visited[?][?][1] 방문 처리 + queue에 넣음
	
	private static void bfs(int startX, int startY) {

		boolean[][][] visited = new boolean[N][M][2];
		visited[startX][startY][0] = true;  // 벽을 안 부수고 방문
		visited[startX][startY][1] = true;  // 벽을 부수고 방문

		Queue<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(startX, startY, 1, false));

		while (!que.isEmpty()) {
			Pos temp = que.poll();
			int x = temp.x;
			int y = temp.y;
			int len = temp.len;
			boolean isBroken = temp.isBroken;

			if (x == N - 1 && y == M - 1) { // 끝까지 간 경우
				res = Math.min(res, len);
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) // 범위를 넘어가면
					continue;
				if (map[nx][ny] == 1) {  // 다음 위치가 벽일 때
					// 이미 벽을 부수고 왔다면 패스
					if (!isBroken && !visited[nx][ny][1]) {  // 현재까지 벽을 부순 적이 없고(두번 깰 수는 없다) 부수고 방문한 적이 없다면
						que.add(new Pos(nx, ny, len + 1, true));
						visited[nx][ny][1] = true;
					}
				} else {  // 다음 위치가 길일 때
					if (isBroken && !visited[nx][ny][1]) { // 현재까지 벽을 부순 적이 있고 부수고 방문한 적이 없다면
						que.add(new Pos(nx, ny, len + 1, true));
						visited[nx][ny][1] = true;
					} else if (!isBroken && !visited[nx][ny][0]) {  // 현재까지 벽을 부순 적이 없고 부수지 않고 방문한 적이 없다면
						que.add(new Pos(nx, ny, len + 1, false));
						visited[nx][ny][0] = true;
					}
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
		res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String temp = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}

		bfs(0, 0);
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}
}
