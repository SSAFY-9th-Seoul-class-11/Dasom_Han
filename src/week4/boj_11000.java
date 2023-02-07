//https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-11000-%EA%B0%95%EC%9D%98%EC%8B%A4-%EB%B0%B0%EC%A0%95-Java

package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 수업 시작, 종료 시간 클래스 생성
class Time implements Comparable<Time>{
	int s;
	int t;
	
	Time(int s, int t) {
		this.s = s;
		this.t = t;
	}
	// 시작 시간을 기준으로 정렬하고, 시작 시간이 같다면 종료 시간을 기준으로 정렬
	// 강의실을 여러개 만들 경우, 시작 시간 순으로 정렬해서 만들어야 최소의 개수로 만들 수 있어서?
	@Override
	public int compareTo(Time o) {
		if (this.s == o.s) {
			return this.t - o.t;
		}
		return this.s - o.s;
	}
}

public class boj_11000 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		// 시간 정보 저장할 배열
		Time[] arr = new Time[N];
		// 우선순위 큐: Time에서 설정한 정렬 기준대로 정렬시켜야 하므로
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			arr[i] = new Time(s, t);
		}
		// 시간 배열 정렬
		Arrays.sort(arr);
		// 우선순위 큐에 첫번째 수업 종료 시간 넣는다
		pq.offer(arr[0].t);
		// 배열을 돌면서
		for (int i = 1; i < N; i++) {
			// 우선순위 큐의 첫번째 값(종료시간)이 배열의 시작시간보다 작다면
			// 한 강의실에서 강의가 이어질 수 있으므로 큐에서 값을 뺀다(강의실 1개로 만듦)
			if (pq.peek() <= arr[i].s) {
				pq.poll();
			}
			// 그게 아니라면 배열 원소의 종료시간이 그냥 그 다음 큐의 원소로 들어오면서 
			// 강의실이 하나 더 늘어남
			pq.offer(arr[i].t);
		}
		// 큐의 크기 = 강의실의 개수 리턴
		System.out.println(pq.size());
	}

}
