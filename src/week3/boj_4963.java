package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class boj_4963 {
	static int w;
	static int h;
	static int island;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
	static Stack<int[]> stk;

	public static void dfs(int X, int Y) {
		stk.push(new int[] { X, Y });
		while (!stk.isEmpty()) {
			int[] cur = stk.pop();
			int x = cur[0];
			int y = cur[1];
			//지나온 곳은 2로 바꿔서 재방문 못하도록 한다
			map[x][y] = 2;
			for (int i = 0; i < 8; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if (nx < 0 || nx >= h || ny < 0 || ny >= w)
					continue;
				if (map[nx][ny] == 1) {  // 다음 목적지가 1이면 이어진 섬이므로 스택에 좌표 추가
					stk.push(new int[] { nx, ny });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			// 너비, 높이, 지도 입력 받기
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			// 0 0이면 반복문 탈출
			if (w == 0 && h == 0)
				break;
			// 지도 배열
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 섬 개수 0으로 초기화
			island = 0;
			// 스택 초기화
			stk = new Stack<int[]>();
			// 1인 경우(섬인 경우) dfs 시작
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						dfs(i, j);
						// dfs를 빠져나왔다는 건 섬을 빠져나왔다는 뜻이므로 섬 개수 + 1
						island++;
					}
				}
			}
			System.out.println(island);
		}

	}

}
