package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_6109 {
	public static int N;
	public static String dir;
	public static int[][] tiles;
	public static int[][] newTiles;
	public static int[][] res;

	// 합치기
	private static List<Integer> sum(Queue<Integer> que) {
		// 합친 결과 넣을 리스트
		List<Integer> newlst = new ArrayList<>();
		while (!que.isEmpty()) {
			// 첫번째 원소를 뺀다
			int temp = que.poll();
			// 마지막 원소였다면 그대로 리스트에 추가
			if (que.size() == 0) {
				newlst.add(temp);
				break;
			}
			// 뒤에 오는 원소가 같은 값이면 그 값도 빼고 둘을 더해서 리스트에 추가
			if (temp == que.peek()) {
				int temp2 = que.poll();
				newlst.add(temp + temp2);
			} else {           // 다른 값이면 그냥 앞의 원소만 추가
				newlst.add(temp);
			}
		}
		// N개의 줄에서 리스트의 사이즈를 뺀만큼 0을 더함
		int zero = N - newlst.size();
		for (int i = 0; i < zero; i++) {
			newlst.add(0);
		}
		return newlst;
	}

	private static void moveUp() {
		for (int col = 0; col < N; col++) {
			// 숫자 수정할 큐 생성
			Queue<Integer> que = new LinkedList<>();
			for (int row = 0; row < N; row++) {
				// 0인 경우를 제외하고 que에 추가
				if (tiles[row][col] == 0)
					continue;
				que.offer(tiles[row][col]);
			}
			// 한줄 완성
			List<Integer> oneLine = sum(que);
			// tiles 업데이트 -> newTiles로
			for (int row = 0; row < N; row++) {
				newTiles[row][col] = oneLine.get(row);
			}
		}
	}

	private static void moveDown() {
		for (int col = 0; col < N; col++) {
			// 숫자 수정할 큐 생성
			Queue<Integer> que = new LinkedList<>();
			for (int row = N - 1; row >= 0; row--) {
				// 0인 경우를 제외하고 que에 추가
				if (tiles[row][col] == 0)
					continue;
				que.offer(tiles[row][col]);
			}
			// 한줄 완성
			List<Integer> oneLine = sum(que);
			// tiles 업데이트 -> newTiles로
			for (int row = N - 1; row >= 0; row--) {
				newTiles[row][col] = oneLine.get(N - row - 1);
			}
		}
	}

	private static void moveLeft() {
		for (int row = 0; row < N; row++) {
			// 숫자 수정할 큐 생성
			Queue<Integer> que = new LinkedList<>();
			for (int col = 0; col < N; col++) {
				// 0인 경우를 제외하고 que에 추가
				if (tiles[row][col] == 0)
					continue;
				que.offer(tiles[row][col]);
			}
			// 한줄 완성
			List<Integer> oneLine = sum(que);
			// tiles 업데이트 -> newTiles로
			for (int col = 0; col < N; col++) {
				newTiles[row][col] = oneLine.get(col);
			}
		}
	}

	private static void moveRight() {
		for (int row = 0; row < N; row++) {
			// 숫자 수정할 큐 생성
			Queue<Integer> que = new LinkedList<>();
			for (int col = N - 1; col >= 0; col--) {
				// 0인 경우를 제외하고 que에 추가
				if (tiles[row][col] == 0)
					continue;
				que.offer(tiles[row][col]);
			}
			// 한줄 완성
			List<Integer> oneLine = sum(que);
			// tiles 업데이트 -> newTiles로
			for (int col = N - 1; col >= 0; col--) {
				newTiles[row][col] = oneLine.get(N - col - 1);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		// 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			// N과 방향 입력 받기
			N = Integer.parseInt(st.nextToken());
			dir = st.nextToken();
			// 타일 배열 초기화
			tiles = new int[N][N];
			newTiles = new int[N][N];
			// 결과 배열 초기화
			res = new int[N][N];
			// 숫자 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					tiles[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 이동
			switch (dir) {
			case "up":
				moveUp();
				break;
			case "down":
				moveDown();
				break;
			case "left":
				moveLeft();
				break;
			case "right":
				moveRight();
				break;
			}
			// 출력
			System.out.println("#" + test_case);
			for (int[] oneLine : newTiles) {
				for (int one : oneLine) {
					System.out.print(one + " ");
				}
				System.out.println();
			}
		}

	}

}
