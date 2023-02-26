package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17070 { // 파이프 옮기기 1

	static int N;
	static int[][] home;
	static int dir;
	static int[][] start = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
	static int[][] horizon = { { 0, 1 }, { 1, 1 } };
	static int[][] vertical = { { 1, 0 }, { 1, 1 } };
	static int[][] diagonal = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
	
	private static void find() {
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		dir = 0;
		home = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		

	}
}
