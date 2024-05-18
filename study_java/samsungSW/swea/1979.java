import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.io.FileInputStream;

class Solution
{

    public static void main(String args[]) throws Exception
    {

        //System.setIn(new FileInputStream("src/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int res = 0;

            int[][] a = new int[n][n];
            for (int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0;j<n;j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 가로 또는 세로로 돌면서 첫 시작 위치인 경우, k칸 연속 비었는지 확인.
            int cnt = 0;
            int totalCnt = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (a[i][j]==1) {
                        cnt++;
                    } else if (cnt>=1 && a[i][j]==0) {
                        if(cnt==k) totalCnt++;
                        cnt=0;
                    }
                }
                if(cnt==k) totalCnt++;
                cnt=0;
            }
            for (int j=0;j<n;j++) {
                for (int i=0; i<n;i++) {
                    if (a[i][j] == 1) {
                        cnt++;
                    } else if(cnt>=1 && a[i][j]==0) {
                        if (cnt==k) totalCnt++;
                        cnt=0;
                    }
                }
                if(cnt==k) totalCnt++;
                cnt=0;
            }
            System.out.println("#"+test_case+" "+totalCnt);
        }
    }
}