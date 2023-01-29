package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10026 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		char[][] painting = new char[N][N];
		for (int i = 0; i < N; i++) {
			String temp = bf.readLine();
			for (int j = 0; j < N; j++) {
				painting[i][j] = temp.charAt(j);
			}
		}
		
		
	}

}
