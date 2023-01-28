package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class swea_1249 {
	// N
	static int N;
	// 정수 2차원 배열
	static int[][] road;
	// 복구시간 저장 배열
	static int[][] time;

	// 상하좌우
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	// BFS 메소드
	public static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { 0, 0 });

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int x = cur[0];
			int y = cur[1];

			// 상하좌우 탐색 후 최소값으로 바꿔주기
			for (int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					int temp = time[x][y] + road[nx][ny];
					if (time[nx][ny] > temp) {
						time[nx][ny] = temp;
						que.add(new int[] { nx, ny });
					}
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(bf.readLine());
			// 2차원 배열 생성
			road = new int[N][N];
			time = new int[N][N];
			// time을 max로 채우기
			for (int i = 0; i < N; i++) {
				Arrays.fill(time[i], Integer.MAX_VALUE);
			}
			// 도로 정보 입력받기
			for (int i = 0; i < N; i++) {
				String temp = bf.readLine();
				for (int j = 0; j < N; j++) {
					road[i][j] = temp.charAt(j) - '0';
				}
			}
			// 시작지 0으로 설정
			time[0][0] = 0;
			// 너비우선탐색 실행
			bfs();
			// 도착지의 time을 반환
			System.out.println("#" + test_case + " " + time[N - 1][N - 1]);
		}
	}

}
