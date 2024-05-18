import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T=10;

        for(int t = 1; t<= T; t++)
        {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[]a = new int[8];
            for (int i=0; i<8; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int cur = 0;  // 현재 시작 index
            boolean flag = true;
            while(flag) {
                for (int i=1; i<=5;i++) {
                    // 한 사이클 실행
                    a[cur] -= i;
                    // 사이클 진행 중 0보다 작아지면 0으로 취급하고 반복문 종료.
                    if (a[cur]<=0) {
                        a[cur] = 0;
                        flag = false;
                        cur = (cur+1)%8;
                        break;
                    }
                    cur = (cur+1)%8;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<8;i++) {
                sb.append(a[cur]+" ");
                cur = (cur+1)%8;
            }
            System.out.println("#"+t+" "+sb);
        }
    }
}