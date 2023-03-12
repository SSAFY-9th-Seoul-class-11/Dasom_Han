package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2096 { // 내려가기

	static int N;
	static int[][] table, dpMax, dpMin;

	private static int paintMax() {
		for (int i = 0; i < 3; i++) {
			dpMax[0][i] = table[0][i];
		}

		for (int line = 1; line < N; line++) { // 최대 점수 구하기
			// 다음줄의 0번째 수는 이전 줄의 0번째 또는 1번째 수와의 합 중 가장 큰 것
			dpMax[line][0] = table[line][0] + Math.max(dpMax[line-1][0], dpMax[line-1][1]);
			// 다음줄의 1번째 수는 이전 줄의 0번째 또는 1번째 또는 2번째 수와의 합 중 가장 큰 것
			dpMax[line][1] = table[line][1] 
					+ Math.max(dpMax[line-1][0], Math.max(dpMax[line-1][1], dpMax[line-1][2]));
			// 다음줄의 2번째 수는 이전 줄의 1번째 또는 2번째 수와의 합 중 가장 큰 것
			dpMax[line][2] = table[line][2] + Math.max(dpMax[line-1][1], dpMax[line-1][2]);
		}

		int max = 0;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, dpMax[N-1][i]);
		}
		return max;
	}
	
	private static int paintMin() {  // 최소 점수 구하기
		for (int i = 0; i < 3; i++) {
			dpMin[0][i] = table[0][i];
		}

		for (int line = 1; line < N; line++) {
			dpMin[line][0] = table[line][0] + Math.min(dpMin[line-1][0], dpMin[line-1][1]); 
			dpMin[line][1] = table[line][1] 
					+ Math.min(dpMin[line-1][0], Math.min(dpMin[line-1][1], dpMin[line-1][2])); 
			dpMin[line][2] = table[line][2] + Math.min(dpMin[line-1][1], dpMin[line-1][2]); 
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, dpMin[N-1][i]);
		}
		return min;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		table = new int[N][3];
		dpMax = new int[N][3];
		dpMin = new int[N][3];

		for (int line = 0; line < N; line++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int num = 0; num < 3; num++) {
				table[line][num] = Integer.parseInt(st.nextToken());
			}
		}
		// dp 배열들 초기화
		for (int line = 0; line < N; line++) {
			for (int num = 0; num < 3; num++) {
				dpMax[line][num] = 0;
				dpMin[line][num] = Integer.MAX_VALUE;
			}
		}

		System.out.println(paintMax() + " " + paintMin());
	}

}
