package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1868 {   // 파핑파핑 지뢰찾기
	
	static int N;
	static char[][] bomb;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(bf.readLine());
			bomb = new char[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				String temp = st.nextToken();
				for (int j = 0; j < N; j++) {
					bomb[i][j] = temp.charAt(j);
				}
			}
			
			
		}
	}

}
