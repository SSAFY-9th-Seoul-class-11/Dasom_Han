package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17404_RGB거리2 {

	static int N;
	static int[][] costs, result;
	static final int R = 0, G = 1, B = 2;

	private static int paint() {
		int min = Integer.MAX_VALUE;
		// 1번째 집 색을 정해놓고 3가지의 경우를 따진다!
		for (int setColor = 0; setColor < 3; setColor++) {
			//1번째 집의 dp 배열 채우기
			for (int firstColor = 0; firstColor < 3; firstColor++) {
				if (setColor == firstColor)
					result[0][firstColor] = costs[0][firstColor];
				else	
					result[0][firstColor] = 9999;
			}
			// DP 배열 완성
			for (int house = 1; house < N; house++) {
				result[house][R] = costs[house][R] + Math.min(result[house - 1][G], result[house - 1][B]); // R의 경우
				result[house][G] = costs[house][G] + Math.min(result[house - 1][R], result[house - 1][B]); // G의 경우
				result[house][B] = costs[house][B] + Math.min(result[house - 1][R], result[house - 1][G]); // B의 경우
			}
			// 최솟값 갱신
			for (int lastColor = 0; lastColor < 3; lastColor++) {
				if (setColor == lastColor)
					continue;
				min = Math.min(min, result[N - 1][lastColor]);
			}
		}
		return min;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		costs = new int[N][3];
		result = new int[N][3];
		for (int house = 0; house < N; house++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int color = 0; color < 3; color++) {
				costs[house][color] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(paint());
	}

}
