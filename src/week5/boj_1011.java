package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1011 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int dist = y - x;
			int d = (int) Math.sqrt(dist);
			if (dist == d * d) {
				System.out.println(2 * d - 1);
			} else if (dist <= d * d + d) {
				System.out.println(2 * d);
			} else {
				System.out.println(2 * d + 1);
			}
		}
	}

}
// https://cocoon1787.tistory.com/622
//이동거리 1 => 작동횟수 1
	// 이동거리 2 => 작동횟수 2
	// 이동거리 3 => 작동횟수 3
//이동거리 4 => 작동횟수 3
	// 이동거리 5 => 작동횟수 4
	// 이동거리 6 => 작동횟수 4
	// 이동거리 7 => 작동횟수 5
	// 이동거리 8 => 작동횟수 5
//이동거리 9 => 작동횟수 5
	// 이동거리 10 => 작동횟수 6
	// 이동거리 11 => 작동횟수 6
	// 이동거리 12 => 작동횟수 6
	// 이동거리 13 => 작동횟수 7
	// 이동거리 14 => 작동횟수 7
	// 이동거리 15 => 작동횟수 7
