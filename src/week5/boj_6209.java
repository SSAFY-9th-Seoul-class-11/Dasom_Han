package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_6209 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] islands = new int[n];
		for (int i = 0; i < n; i++) {
			islands[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(islands);
		
		int left = 0;
		int right = d;
		while(left <= right) {
			int mid = (left + right) / 2;
		}
	}

}
