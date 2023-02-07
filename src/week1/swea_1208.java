package week1;
import java.util.Scanner;
import java.io.FileInputStream;
 
public class swea_1208 {
	// 가장 높은 곳의 박스 개수와 인덱스 반환 함수
    public static int[ ] returnMax(int arr[ ]) {
        int[ ] Max = {0, 0};
        for(int i = 0; i < 100; i++) {
            if(arr[i] > Max[0]) {
                Max[0] = arr[i];
                Max[1] = i;
            }
        }
        return Max;
    }
    // 가장 낮은 곳의 박스 개수와 인덱스 반환 함수
    public static int[ ] returnMin(int[ ] arr) {
        int[ ] Min = {1001, 0};
        for(int i = 0; i < 100; i++) {
            if(arr[i] < Min[0]) {
                Min[0] = arr[i];
                Min[1] = i;
            }
        }
        return Min;
    }
    // 덤핑 작업 함수: 최대 개수 위치에서 -1, 최소 개수 위치에서 +1 하여 배열 반환
    public static int[ ] dumping(int[ ] arr, int dump) {
        for(int i = 0; i < dump; i++) {
            int[] Max = returnMax(arr);
            int[] Min = returnMin(arr);
            arr[Max[1]] -= 1;
            arr[Min[1]] += 1;
        }
        return arr;
    }
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
         
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int dump = sc.nextInt();
            int[ ] boxes = new int[100];
            for(int i = 0; i < 100; i++) {
                boxes[i] = sc.nextInt();
            }
            // 덤핑 작업 수행
            int[] resArr = dumping(boxes, dump);
            // 덤핑 종료 후 최대 박스 개수와 최소 박스 개수 구하기
            int resMax = returnMax(resArr)[0];
            int resMin = returnMin(resArr)[0];
            // 최종 결과값
            int res = resMax - resMin;
             
            System.out.println("#"+test_case+" "+res);
        }
    }
}