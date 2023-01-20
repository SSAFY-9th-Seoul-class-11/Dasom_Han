
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int T = Integer.parseInt(bf.readLine());
            Queue<Integer> que = new LinkedList<>();
            
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < 8; i++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
            //입력받기
            
            //0이 끝나면 종료, 5번이 1사이클
            boolean cycle = true;
            while(cycle) {
            	for (int i = 0; i < 5; i++) {
					int temp = que.remove() - (i+1);
					if (temp <= 0) {
						que.add(0);
						cycle = false;
					} else {
						que.add(temp);
					}
				}
            }
            
            System.out.print("#" + test_case + " ");
            for (Integer c : que) {
				System.out.print(c + " ");
			}
            System.out.println();
		}
	}
}