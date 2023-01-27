package week2;

import java.io.IOException;
import java.util.Scanner;

public class boj_1541 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String temp = sc.next();
		// - 를 기준으로 문자열을 나누고 배열로 저장
		String[] tempStrings = temp.split("-");

		int res = 0;
		// + 를 포함하는 문자열을 찾은 후 문자열을 정수로 바꾸고, 빼기 연산한다
		for(int i = 0; i < tempStrings.length; i++) {
			int sum = 0;
			String[] tempPlus = tempStrings[i].split("\\+");
			for (int j = 0; j < tempPlus.length; j++) {
				sum += Integer.parseInt(tempPlus[j]);
			}
			// 시작일 때만 더하고 그 뒤로는 뺀다
			if (i == 0) {
				res += sum;
			} else {
				res -= sum;
			}
		}
		
		System.out.println(res);

	}

}
