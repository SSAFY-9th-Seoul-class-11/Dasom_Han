package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_스도쿠_한다솜 {
	
	static int[][] sdk;
	
	public static boolean fill(int i, int j, int k) {
		return false;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sdk = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String oneRow = bf.readLine();
			for (int j = 0; j < 9; j++) {
				sdk[i][j] = oneRow.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sdk[i][j] == 0)
					fill(i, j);
			}
		}
		
	}

}
