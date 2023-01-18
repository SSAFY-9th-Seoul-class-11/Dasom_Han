import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int hundred = Integer.parseInt(bf.readLine());	
			int[][] mag = new int[100][100];	
            // 문자열을 공백을 기준으로 나누고 정수화하여 2차원 배열에 저장
			for(int i = 0; i < 100; i++) {	
                StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j = 0; j < 100; j++) {
					mag[i][j] = Integer.parseInt(st.nextToken());
                }
			}
            
            int sum = 0;
			//1과 2가 연달아 나오는 상황일 때 sum += 1
			for (int i = 0; i < 100; i++) {
                int last = 0; //마지막 자석
				for (int j = 0; j < 100; j++) {
                    if (mag[j][i] == 1) {
                        last = 1;
                    } else if (mag[j][i] == 2) {
                        if(last == 1) {
                            sum += 1;
                        } 
                        last = 2;
                    }
				}
			}
            
            System.out.println("#" + test_case + " " + sum);
		}
		
	}

}
