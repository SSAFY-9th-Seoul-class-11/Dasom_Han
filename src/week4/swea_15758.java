package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_15758 {

	private static String S;
	private static String T;

	public static boolean isSame(String S, String T) {
		// 늘린 문자열 저장
		StringBuilder sb_s = new StringBuilder();
		StringBuilder sb_t = new StringBuilder();

		int s = S.length();
		int t = T.length();
		// 최대공약수
		int gcd = 0;
		for (int i = 1; i <= t; i++) {
			if (s % i == 0 && t % i == 0) {
				gcd = i;
			}
		}
		// 최소공배수
		int lsm = s * t / gcd;
		// 각 문자마다 repeat 하면서 같은 길이의 문자열을 만들고 비교
		for (int i = 0; i < lsm / s; i++) {
			sb_s.append(S);

		}
		for (int i = 0; i < lsm / t; i++) {
			sb_t.append(T);

		}
		// 같으면 true, 다르면 false 리턴
		if (sb_s.toString().equals(sb_t.toString())) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String tmp1 = st.nextToken();
			String tmp2 = st.nextToken();
			// 더 긴 것을 S, 더 짧은 것을 T라고 정했다
			if (tmp1.length() > tmp2.length()) {
				S = tmp1;
				T = tmp2;
			} else {
				S = tmp2;
				T = tmp1;
			}
			// 같다면 yes, 다르면 no
			if (isSame(S, T)) {
				System.out.println("#" + test_case + " yes");
			} else {
				System.out.println("#" + test_case + " no");
			}

		}

	}

}
