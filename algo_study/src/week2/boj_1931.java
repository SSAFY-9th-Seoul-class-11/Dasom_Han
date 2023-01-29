package week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] meet = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 2; j++) {
				meet[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력
		
		
		Arrays.sort(meet, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		// 정렬
		
		int cnt = 0;
		int endTime = 0;
		for (int i = 0; i < N; i++) {
			if (endTime <= meet[i][0]) {
				endTime = meet[i][1];
				cnt++;
			}
		}
		//끝나는 시간과 시작시간 비교 후 갱신
		
		System.out.println(cnt);
		
	}
	
}
