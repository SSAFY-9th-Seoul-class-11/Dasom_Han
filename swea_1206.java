import java.util.Scanner;
import java.io.FileInputStream;

class Solution
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
            int res = 0;
            for(int i = 2; i < N - 2; i++) {
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