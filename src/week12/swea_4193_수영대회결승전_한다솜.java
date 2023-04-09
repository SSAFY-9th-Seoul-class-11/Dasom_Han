package week12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_4193_수영대회결승전_한다솜 {

	static class Swirl {
		int x, y, status;

		public Swirl(int x, int y, int status) {
			this.x = x;
			this.y = y;
			this.status = status;
		}

	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int N, ans, sX, sY, eX, eY;
	static int[][] sea;
	static List<Swirl> swirls;
	static final int[][] DIR = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	private static void updateSea() {
		for (Swirl s : swirls) {
			if (s.status == 2) {
				sea[s.x][s.y] = 1;
				s.status = 1;
			} else if (s.status == 1) {
				sea[s.x][s.y] = 0;
				s.status = 0;
			} else if (s.status == 0) {
				sea[s.x][s.y] = 2;
				s.status = 2;
			}
		}
	}

	private static int bfs() {
		boolean[][] visited = new boolean[N][N];
		Queue<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(sX, sY));
		visited[sX][sY] = true;
		int time = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int s = 0; s < size; s++) {
				Pos now = que.poll();
				int x = now.x;
				int y = now.y;
				if (x == eX && y == eY) // 도착
					return time;
				for (int d = 0; d < 4; d++) {
					int nx = x + DIR[d][0];
					int ny = y + DIR[d][1];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (visited[nx][ny] || sea[nx][ny] == 3)
						continue;
					if (sea[nx][ny] > 0) {  // 소용돌이면 다시 그자리를 큐에 추가
						que.offer(now);
						continue;
					}
					visited[nx][ny] = true;
					que.offer(new Pos(nx, ny));
				}
			}
			updateSea();
			time++;
		}
		return -1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(bf.readLine());
			sea = new int[N][N];
			swirls = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					sea[i][j] = Integer.parseInt(st.nextToken());
					if (sea[i][j] == 2)
						swirls.add(new Swirl(i, j, 2)); // 소용돌이 리스트에 추가
					else if (sea[i][j] == 1)
						sea[i][j] = 3;
				}
			}
			StringTokenizer st = new StringTokenizer(bf.readLine()); // 시작, 도착 지점
			sX = Integer.parseInt(st.nextToken());
			sY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			eX = Integer.parseInt(st.nextToken());
			eY = Integer.parseInt(st.nextToken());

			System.out.println("#" + test_case + " " + bfs());
		}

	}

}
