package week1;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[][] farm = new int[N][N];
            // 수익
            int res = 0;
            // 2차원 배열로 농장의 농작물 값 초기화
            for(int i = 0; i < N; i++) {
            	// 숫자가 붙어서 오므로 먼저 문자열로 받는다
            	String temp = sc.next();
            	for(int j = 0; j < N; j++) {
            		//문자열에서 문자 하나를 자르고 정수로 변환
                	farm[i][j] = Character.getNumericValue(temp.charAt(j));
                }
            }
            // 마름모 위쪽
            for(int i = 0; i < N/2 + 1; i++) {
            	for(int j = -i; j <= i; j++) {
                	res += farm[i][N/2 + j];
                }
            }
            // 마름모 아래쪽
            for(int i = 1; i < N/2 + 1; i++) {
            	for(int j = i; j <= N - 1 - i; j++) {
                	res += farm[N/2 + i][j];
                }
            }
            
            System.out.println("#"+test_case+" "+res);
		}
	}
}