import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int t = 1; t <= T; t++)
        {
            char[] arr = sc.next().toCharArray();
            int cnt = 0;
            char before = '0';
            for (int i=0; i<arr.length;i++) {
                if (before != arr[i]) {
                    // 현재 값이 다르다면 버튼 누르기
                    before = arr[i];  // 이후 값들은 모두 arr[i]값으로 변경된다.
                    cnt++;
                }
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
}