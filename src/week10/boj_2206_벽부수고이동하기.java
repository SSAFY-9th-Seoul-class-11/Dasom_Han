import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, res;
	static int[][] map;
	static int[][] lenMap;
	static boolean[][][] visited;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	private static void bfs(int startX, int startY) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { startX, startY });
		int x = 0;
		int y = 0;
		visited[0][0][0] = true;
		lenMap[x][y] = 1;
		loop: while (!que.isEmpty()) {
			int[] temp = que.poll();
			x = temp[0];
			y = temp[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1]; 
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) // 범위를 넘어가면
					continue;
				if (visited[x][y][1] && map[nx][ny] == 1) // 벽을 두번 만난 경우
					continue;
				if (visited[nx][ny][0] && visited[nx][ny][1]) // (벽을 부수고 갔거나 안 부수고 간 두 경우 다) 지나왔다면..
					continue;
				if (nx == N - 1 && ny == M - 1) {  // 끝까지 간 경우
					lenMap[nx][ny] = lenMap[x][y] + 1;
					x = nx;
					y = ny;
					break loop;
				}
				if (!visited[x][y][1] && map[nx][ny] == 1) { // 벽을 1번 만난 경우
					visited[nx][ny][1] = true;
				} else if (!visited[x][y][0] && map[nx][ny] == 0) {  // 벽을 안 만난 경우
					visited[nx][ny][0] = true;
				}
				lenMap[nx][ny] = lenMap[x][y] + 1;
				que.offer(new int[] { nx, ny }); // 벽이 없거나 1번 부순 경우
			}
		}
		if (x != N - 1 && y != M - 1)
			lenMap[N - 1][M - 1] = -1;   // 끝까지 못가면 -1
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		lenMap = new int[N][M];
		visited = new boolean[N][M][2]; // 방문 배열, 벽 없이 왔을 때와 벽 한번 깨고 왔을 때
		for (int i = 0; i < N; i++) {
			String temp = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}

		bfs(0, 0);
		System.out.println(lenMap[N - 1][M - 1]);
	}
}
