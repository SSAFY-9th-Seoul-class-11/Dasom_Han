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

		int answer = 0;
		int left = 0;
		int right = d;

		while(left <= right) {
			int mid = (left + right) / 2;
			int prev = 0;
			int cnt = 0;

			for(int island : islands) {
				if (island - prev < mid) {
					cnt++;
					continue;
				}

				prev = island;
			}

			if (d - prev < mid) {
				cnt++;
			}

			if (cnt > m) {
				right = mid - 1;
				continue;
			}

			answer = Math.max(answer, mid);
			left = mid + 1;
		}

		System.out.println(answer);
	}

}
// https://fomaios.tistory.com/entry/Swift-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A7%95%EA%B2%80%EB%8B%A4%EB%A6%AC-with-%EC%89%AC%EC%9A%B4-%ED%92%80%EC%9D%B4-%ED%8F%AC%ED%95%A8
// left =1, right = distance, mid = (left+right)/2 로 정의하고 
// 각각의 바위들 사이의 거리가 중간 값보다 작을 때는 해당 바위를 제거해야 하고 
// 이렇게 제거된 바위들의 수가 제거할 바위의 수 n 보다 같거나 작다면 거리의 최솟값은 더 증가해야 한다. 
// 따라서 right = mid +1 이 된다. 반대로 제거된 바위들의 수가 n 보다 크다면 중간 값은 작아져야 하고
// left = mid-1이 된다. 이런식으로 무한 루프를 돌다 right<=left 가 될 때 빠져나오면 된다. 