import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
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
            int[] resArr = dumping(boxes, dump);
            int resMax = returnMax(resArr)[0];
            int resMin = returnMin(resArr)[0];
            int res = resMax - resMin;
             
            System.out.println("#"+test_case+" "+res);
        }
    }
}