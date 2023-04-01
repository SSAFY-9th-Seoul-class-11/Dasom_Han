package week11;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj_13549_숨바꼭질3 {

	static int N, K;
	static int[] location;

	public static boolean isValid(int loc) {
		if (loc < 0 || loc > 100000) // 범위를 벗어나거나
			return false;
		if (location[loc] != 0) // 그 위치에 이미 다녀갔거나
			return false;
		return true;
	}

	public static void bfs() {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { N, 0 }); // 시작(수빈)

		while (!que.isEmpty()) {
			int[] subin = que.poll();
			int currLoc = subin[0];
			int time = subin[1];
			location[currLoc] = time;
			if (currLoc == K)
				return;
			if (isValid(currLoc - 1))
				que.offer(new int[] { currLoc - 1, time + 1 });
			if (isValid(currLoc + 1))
				que.offer(new int[] { currLoc + 1, time + 1 });
			if (isValid(currLoc * 2))
				que.offer(new int[] { currLoc * 2, time });
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수빈 위치
		K = sc.nextInt(); // 동생 위치
		location = new int[100001]; // 수직선
		bfs();
		System.out.println(location[K]);
	}

}
