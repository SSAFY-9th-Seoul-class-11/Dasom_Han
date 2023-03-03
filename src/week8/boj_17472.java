package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17472 {

	static class Bridge implements Comparable<Bridge> {
		int no, weight;

		public Bridge(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Bridge o) {
			return this.weight - o.weight;
		}

	}

	static int[][] map;
	static boolean[][] visited;
	static int N, M, island;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] adjMatrix;
	static PriorityQueue<Bridge> pq;
	static int res;
	static int[] minLength;
	static boolean[] visitedIsland;

	private static void findPath(int startX, int startY, int index) {
		
		Stack<int[]> stack = new Stack<>();
		for (int d = 0; d <= 1; d++) {
			stack.push(new int[] { startX, startY });
			while(!stack.isEmpty()) {
				int[] curr = stack.pop();
				int x = curr[0];
				int y = curr[1];
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (nx >= N || ny >= M || map[nx][ny] == index)
					continue;
				if (map[nx][ny] == 0) {
					stack.push(new int[] { nx, ny });
				}
				if (map[nx][ny] != index) { // 다른 섬에 도착!
					int dist = (nx - startX) + (ny - startY) - 1;
					if (dist > 1) { // 길이 1인 다리는 만들지 않음
						// 이미 다리가 있다면 최소 길이로 업데이트
						adjMatrix[index][map[nx][ny]] = Math.min(adjMatrix[index][map[nx][ny]], dist);
						adjMatrix[map[nx][ny]][index] = Math.min(adjMatrix[map[nx][ny]][index], dist);
					}
				}
			}
		}
	}

	private static void findIsland(int startX, int startY) { // 섬찾기 함수

		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { startX, startY });
		while (!que.isEmpty()) {
			int[] start = que.poll();
			int x = start[0];
			int y = start[1];
			map[x][y] = island;
			visited[x][y] = true;
			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
					continue;
				if (map[nx][ny] == -1) {
					map[nx][ny] = island;
					visited[nx][ny] = true;
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
		visited = new boolean[N][M];
		pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) 
					map[i][j] = -1;
			}
		}
		// --------입력---------

		island = 0; // 섬의 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == -1) {
					island++;
					visited[i][j] = true;
					findIsland(i, j);
				}
			}
		}
		// -------섬찾기-------

		adjMatrix = new int[island + 1][island + 1]; // 섬과 섬 사이 최소 다리 길이 저장하는 배열
		for (int i = 0; i <= island; i++) {
			for (int j = 0; j <= island; j++) {
				adjMatrix[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int k = 1; k <= island; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == k)
						findPath(i, j, k);
				}
			}
		}
		// -------가능한 모든 길찾기--------

		minLength = new int[island + 1];
		for (int i = 0; i <= island; i++) {
			minLength[i] = Integer.MAX_VALUE;
		}
		// -------다리 최소 길이 배열 초기화-----

		visitedIsland = new boolean[island + 1];
		minLength[1] = 0; // 1번 섬부터 시작하자
		pq.offer(new Bridge(1, 0));
		int cnt = 0; // 모든 섬 다 들렀는지 확인
		while (!pq.isEmpty()) {
			Bridge minBridge = pq.poll();
			if (visitedIsland[minBridge.no])
				continue;
			res += minBridge.weight;
			visitedIsland[minBridge.no] = true;

			if (++cnt == island) // 모든 섬 다 돌았을 때
				break;

			for (int i = 1; i <= island; i++) {
				if (!visitedIsland[i] && adjMatrix[minBridge.no][i] < Integer.MAX_VALUE && minLength[i] > adjMatrix[minBridge.no][i]) {
					minLength[i] = adjMatrix[minBridge.no][i];
					pq.offer(new Bridge(i, minLength[i]));
				}
			}
		}

		System.out.println(cnt == island ? res : -1);

	}

}
