package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_3019 {  // 테트리스

	static int C, P, answer;
	static int[] field;
	static int[][][] blocks = { { { 0 }, { 0, 0, 0, 0 } }, // block1
			{ { 0, 0 } }, // block2
			{ { 0, 0, 1 }, { 1, 0 } }, // block3
			{ { 1, 0, 0 }, { 0, 1 } }, // block4
			{ { 0, 0, 0 }, { 0, 1 }, { 1, 0, 1 }, { 1, 0 } }, // block5
			{ { 0, 0, 0 }, { 0, 0 }, { 0, 1, 1 }, { 2, 0 } }, // block6
			{ { 0, 0, 0 }, { 0, 2 }, { 1, 1, 0 }, { 0, 0 } } }; // block7

	private static void findWays() {
		int degree = blocks[P - 1].length; // 0도, 90도, 180도, 270도 중 다른 경우들만
		for (int d = 0; d < degree; d++) {
			int len = blocks[P - 1][d].length;
			for (int i = 0; i <= C - len; i++) { // 필드 옮겨가며
				int last = field[i] - blocks[P - 1][d][0];
				boolean flag = true;
				for (int l = 0; l < len; l++) {
					if (last != (field[i + l] - blocks[P - 1][d][l]))
						flag = false;
				}
				if (flag)
					answer++;
			}
		}
	}

	public static void main(String[] args) throws IOException { // 테트리스
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		C = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		field = new int[C];

		st = new StringTokenizer(bf.readLine());
		int min = 101; // 제일 작은 값 찾기
		for (int i = 0; i < C; i++) {
			field[i] = Integer.parseInt(st.nextToken());
			if (field[i] < min) 
				min = field[i];
		}
		// 정규화
		for (int i = 0; i < C; i++) {
			field[i] -= min;
		}

		findWays();
		System.out.println(answer);
	}

}
