import java.io.*;
import java.util.*;

public class Solution {

    public static int diff;  // 단차
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1 ; test_case <= 10 ; test_case++) {
            int[] arr = new int[100];
            int count = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<100;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            // 덤프 횟수만큼 평탄화 진행
            while(count-->0) {
                // 오름차순 정렬
                Arrays.sort(arr);

                // 가장 큰 수와 가장 작은 수 1씩 교체
                arr[0] +=1;
                arr[99] -=1;
            }
            Arrays.sort(arr);
            System.out.println("#" + test_case + " " + (arr[99]-arr[0]));
        }
    }
}