package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(bf.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(bf.readLine());
            // N+1개 배열 생성, 인덱스가 배열의 원소가 되고 값은 그 인덱스 값을 갖는 원소의 개수
            // 따라서 배열의 값이 2이상이면 순열이 안된다는 것
            int[] numbers = new int[N + 1];
            // 답
            String res = "Yes";
            // 입력받기
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                int inNum = Integer.parseInt(st.nextToken());
                // 값이 1보다 커지면 중복되므로 순열이 아님. break로 빠져나온다
                if(++numbers[inNum] > 1) {
                    res = "No";
                    break;
                }
            }
            if(res == "Yes") {
                for (int i = 1; i <= N; i++) {
                    if(numbers[i] == 0) {
                        res = "No";
                        break;
                    }
                }
            }
            System.out.println("#" + test_case + " " + res);
 
        }
    }
}
