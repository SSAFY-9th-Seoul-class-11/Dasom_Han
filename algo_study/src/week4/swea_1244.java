package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_1244 {

	static private char[] num;
	static private int cnt;
	static private ArrayList<Integer> num_list;
	static private int max;
	
	public static int casting() {
		String tempStr = num.toString();
		int tempInt = Integer.parseInt(tempStr);
		return tempInt;
	}
	
	public static void swap(int a, int b) {
		char temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}

	public static void exchange() {
		int size = num.length;
		max = 0;
		
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				swap(i, j);
				int temp = casting();
				if (temp > max) {
					max = temp;
				}
				swap(i, j);
			}
			
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String temp = st.nextToken();
			num = temp.toCharArray();
			cnt = Integer.parseInt(st.nextToken());
			exchange();
			System.out.println("#" + test_case + " " + max);
		}
	}

}
