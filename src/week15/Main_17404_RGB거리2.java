package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17404_RGB거리2 {
	
	static int N;
	static int[][] costs, result;
	
	private static int paint() {
		// 첫줄과 마지막은 result를 costs와 똑같이 채우기
		for (int i = 0; i < 3; i++) {
			result[0][i] = costs[0][i];
		}
		// 둘째줄부터 그 전 집과 색이 다르면서 최소인 경우 저장
		for (int house = 1; house < N; house++) {
			result[house][0] = costs[house][0] + Math.min(result[house-1][1], result[house-1][2]); // R의 경우 G, B
			result[house][1] = costs[house][1] + Math.min(result[house-1][0], result[house-1][2]); // G의 경우 R, B
			result[house][2] = costs[house][2] + Math.min(result[house-1][0], result[house-1][1]); // B의 경우 R, G
		}
		// 마지막줄의 최소값
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, result[N-1][i]);
		}
		return min;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		costs = new int[N][3];
		result = new int[N + 1][3];
		for (int house = 0; house < N; house++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int color = 0; color < 3; color++) {
				costs[house][color] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int house = 0; house <= N; house++) {
			for (int color = 0; color < 3; color++) {
				result[house][color] = Integer.MAX_VALUE;
			}
		}

		System.out.println(paint());
	}

}
