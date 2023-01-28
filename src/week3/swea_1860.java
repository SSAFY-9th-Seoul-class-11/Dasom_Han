package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1860 {

	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			// N명, M초, K개 입력받기
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			// 사람들이 도착하는 시간 저장하는 배열
			int[] arrive = new int[N];
			// 가장 늦게 오는 사람의 시간
			int last = 0;
			// 붕어빵의 수
			int boong = 0;
			// 결과
			String res = "Possible";
			// N명의 사람들이 도착하는 시간 저장
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				int a = Integer.parseInt(st2.nextToken());
				arrive[i] = a;
			}
			// 시간 순대로 돌아야 하므로 정렬해줌
			Arrays.sort(arrive);
			last = arrive[N - 1];
			// 마지막 시간까지 반복문
			loop : for (int time = 0; time < last + 1; time++) {
				// M초마다 붕어빵 K개 추가
				if (time % M == 0 && time != 0) {
					boong += K;
				}
				// 사람들 도착할 때마다 붕어빵 -1
				for (int one : arrive) {
					if (time == one) {
						boong -= 1;
						// 만약 붕어빵이 음수이면 결과는 impossible
						if (boong < 0) {
							res = "Impossible";
							break loop;
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + res);

		}
	}

}
