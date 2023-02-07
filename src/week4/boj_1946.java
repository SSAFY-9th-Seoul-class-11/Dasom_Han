package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 지원자 클래스 생성
class Vol implements Comparable<Vol> {
	// 서류, 인터뷰 등수 담는 변수
	int resume;
	int interv;

	Vol(int resume, int interv) {
		this.resume = resume;
		this.interv = interv;
	}

	// 서류 기준 정렬
	@Override
	public int compareTo(Vol o) {
		return this.resume - o.resume;
	}

}

public class boj_1946 {

	static List<Vol> arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		// 테스트 케이스
		for (int test_case = 0; test_case < T; test_case++) {
			// 지원자의 수 N
			int N = Integer.parseInt(bf.readLine());
			// 지원자 리스트 생성
			arr = new ArrayList<Vol>();
			// 지원자 정보 담기
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int resume = Integer.parseInt(st.nextToken());
				int interv = Integer.parseInt(st.nextToken());
				arr.add(new Vol(resume, interv));
			}
			// 서류 등수대로 정렬
			Collections.sort(arr);
			// 1등 포함 합격자
			int res = 1;
			// 1등의 면접 등수
			int min = arr.get(0).interv;
			for (int i = 0; i < N; i++) {
				// 1등의 면접 등수보다 더 높다면 이 사람은 합격이다
				if (arr.get(i).interv < min) {
					res++;
					// 등수 업데이트
					min = arr.get(i).interv;
				}
			}
			// 결과 출력
			System.out.println(res);
		}
	}

}
