package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_9229 {
	static int[] chips;
	static int N;
	static int M;
	
	public static int largestWeight(int count, int weight, int two) {
		if (weight > M) {
			return -1;
		}
		if (two == 0) {
			return weight;
		}
		if (count == N) {
			return -1;
		}
		int plus = largestWeight(count + 1, weight + chips[count], two - 1);
		int nope = largestWeight(count + 1, weight, two);
		return Math.max(plus, nope);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(bf.readLine());
			// N, M 입력받기
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			// 과자 무게 저장할 배열 생성 및 저장
			chips = new int[N];
			for (int i = 0; i < N; i++) {
				chips[i] = Integer.parseInt(st.nextToken());
			}
			// 과자 배열 
			int idx = 0;
			// 무게
			int weight = 0;
			// 두개 사야함
			int two = 2;
			largestWeight(idx, weight, two);
			System.out.println("#" + test_case + " " + largestWeight(idx, weight, two));
		}
	}

}
