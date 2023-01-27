package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// Edge 클래스 생성
class Edge implements Comparable<Edge> {
	int A, B, C;
	
	Edge(int A, int B, int C) {
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	public int compareTo(Edge o) {
		return this.C - o.C;
	}
}
// kruskal 알고리즘 사용
public class boj_1197 {
	// edges와 parent 선언
	static Edge[] edges;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 정점과 간선 개수 입력받기
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		// Edge 배열 생성
		edges = new Edge[E];
		// 부모 노드 배열 생성 및 각자 노드의 부모를 자신으로 설정
		parent = new int[V+1];
		for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
		// 최소 가중치 선언
		int min_cost = 0;		

		// A,B,C 입력받아 edges 배열에 저장
		for (int i = 0; i < E; i++) {
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			int A = Integer.parseInt(st2.nextToken());
			int B = Integer.parseInt(st2.nextToken());
			int C = Integer.parseInt(st2.nextToken());

			edges[i] = new Edge(A, B, C);
		}
		// 간선 크기 오름차순 정렬
		Arrays.sort(edges);
		// 두 정점이 같은 그룹이면 넘어가고 다른 그룹이면 같은 그룹으로 만들고 트리에 추가
		for (Edge edge : edges) {
			if(find(edge.A) == find(edge.B)) {
				continue;
			} else {
				union(edge.A, edge.B);
				min_cost += edge.C;
			}
		}
		// 결과 출력
		System.out.println(min_cost);
		
	}
	// 부모가 누구인지 찾아주는 함수
	public static int find(int child) {
		if(parent[child] == child) {
			return child;
		} else {
			return parent[child] = find(parent[child]);
		}
	}
	// 부모가 다르다면 같게 만들어줌, 즉 같은 그래프로 합침
	public static void union(int A, int B) {
		A = find(A);
		B = find(B);
		if(A != B) {
			parent[B] = A;
		}
	}

}
