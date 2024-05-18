import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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
        T=Integer.parseInt(br.readLine());


        for(int t = 1; t<= T; t++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());  // A사 1리터당 p원
            int q = Integer.parseInt(st.nextToken());  // B사 기본요금 q원
            int r = Integer.parseInt(st.nextToken());  // r리터 이하면 기본요금만
            int s = Integer.parseInt(st.nextToken());  // 초과분 1리터당 원
            int w = Integer.parseInt(st.nextToken());  // 사용한 수도 양 w리터

            // 요금이 저렴한 회사를 골라 그 요금 출력
            // A사 계산
            long mountA = (long)w*p;
            // B사 계산
            long mountB;
            if (w<r) {
                // 기준 값 이하면 기본요금
                mountB = (long) q;
            } else {
                mountB = (long) q;
                mountB += (long)(w-r)*s;
            }

            if (mountA > mountB) {
                // a가 더 비싼 경우
                System.out.println("#"+t+" "+mountB);
            } else {
                // b가 더 비싼 경우
                System.out.println("#"+t+" "+mountA);
            }
        }
    }
}