package week1;
import java.util.Scanner;
import java.io.FileInputStream;

public class swea_1206
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int N = sc.nextInt();
            int[ ] apt = new int[N];
            for(int i = 0; i < N; i++) {
                apt[i] = sc.nextInt();
            }
            //결과값 초기화
            int res = 0;
            //처음 2칸과 끝 2칸은 0이므로 범위를 다음과 같이 설정
            for(int i = 2; i < N - 2; i++) {
            	//내 주변 -2 ~ +2 에 위치한 아파트와 비교하여 제일 큰 경우, 그 다음 큰 아파트 층수와의 차를 결과값에 더하기
                if(apt[i] > apt[i-2] && apt[i] > apt[i-1] && apt[i] > apt[i+1] && apt[i] > apt[i+2]) {
                    int max1 = Math.max(apt[i-2], apt[i-1]);
                    int max2 = Math.max(apt[i+2], apt[i+1]);
                    res += apt[i] - Math.max(max1, max2);
                }
            }
            System.out.println("#"+test_case+" "+res);
		}
	}
}