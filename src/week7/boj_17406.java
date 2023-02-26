package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17406 { // 배열 돌리기 4

	static int N, M, K;
	static int[][] arr;
	static int[][] calc;
	static boolean[] isSelected;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[] seq;
	static List<int[]> seqList;
	static List<Integer> sumList;

	private static void swap(int x, int y) {
		int temp = seq[x];
		seq[x] = seq[y];
		seq[y] = temp;
	}

	private static void getSeq(int curr) { // 연산 순서의 경우를 구함

		if (curr == K - 1) {
			seqList.add(seq);
			//
			System.out.println("종류:" + Arrays.toString(seq));
			//
			return;
		}

		for (int i = curr; i < K; i++) {
			swap(curr, i);
			getSeq(curr + 1);
			swap(i, curr);
		}
	}

	private static int getMin(int[][] arr) { // "배열의 값" 구하기

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += arr[i][j];
			}
			min = Math.min(min, sum);
		}

		return min;
	}

	private static int[][] spin(int calcIdx, int[][] origin) { // 회전

		int[][] arr3 = new int[N][M];
		for (int r = 0; r < N; r++) {
			System.arraycopy(origin[r], 0, arr3[r], 0, M);
		}
		int r = calc[calcIdx][0] - 1;
		int c = calc[calcIdx][1] - 1;
		int s = calc[calcIdx][2];
		int startX = r - s;
		int startY = c - s;
		int endX = r + s;
		int endY = c + s;

		for (int i = 0; i < s; i++) {
			int x = startX + i;
			int y = startY + i;
			for (int d = 0; d < 4; d++) {
				while (true) {
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];
					if (nx < startX + i || nx > endX - i || ny < startY + i || ny > endY - i) {
						break;
					}
					arr3[nx][ny] = origin[x][y];
					x = nx;
					y = ny;
				}
			}
		}
		return arr3;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		calc = new int[K][3]; // 연산 종류 배열
		seq = new int[K]; // 연산 순서
		for (int i = 0; i < K; i++) {
			seq[i] = i;
		}
		seqList = new ArrayList<int[]>(); // 연산 순서 리스트
		sumList = new ArrayList<Integer>(); // 배열값 리스트

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				calc[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		getSeq(0); // 연산 순서의 경우를 구함
		for (int i = 0; i < seqList.size(); i++) {
			//
			System.out.println(Arrays.toString(seqList.get(i)));
			//
			int[][] arr2 = new int[N][M];           // 연산 순서에 따라 배열이 달라지므로 새 배열 생성
			for (int r = 0; r < N; r++) {
				System.arraycopy(arr[r], 0, arr2[r], 0, M);   
			}
			for (int j = 0; j < K; j++) {
				arr2 = spin(seqList.get(i)[j], arr2);  
				//
				for (int[] aa : arr2) {
					for (int a : aa) {
						System.out.print(a);
					}
					System.out.println();
				}
				System.out.println();
				//
			}

			sumList.add(getMin(arr2));
		}
		
		

		Collections.sort(sumList);
		System.out.println(sumList.get(0));
	}

}
