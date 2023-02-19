package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5248 {  // 그룹나누기
	
	static int[] parent;
	static int N;
	static int M;
	static int res;
	
	private static void union(int A, int B) {
		int pA = find(A);      // A의 부모 찾기
		int pB = find(B);      // B의 부모 찾기
		if (pA != pB) {         // 둘의 부모가 다르다면
			parent[pB] = parent[pA];    // 같게 만들어준다
			res--;         // 같아지는 순간 서로 다른 팀의 개수는 -1됨
		}
		
	}
	
	private static int find(int A) {
		if (parent[A] == A) {     // 스스로가 부모라면 그대로 리턴
			return A;
		} else {
			return find(parent[A]);     // 아니면 부모의 부모를 거슬러 올라감
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			res = N;                    // 조의 개수
			parent = new int[N + 1];        // 부모배열 생성
			for (int i = 1; i <= N; i++) {
				parent[i] = i;           // 처음은 자기자신이 부모(=팀장)
			}
			
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < M; i++) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				union(A, B);            // 합치기 작업
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}

}
