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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int total = 0;

            for (int i=0;i<10;i++) {
                int cur = Integer.parseInt(st.nextToken());

                total += cur;
                max = Math.max(max, cur);
                min = Math.min(min, cur);
            }
            total = total - max - min;
            int res = (int)Math.round(total/8.0);
            System.out.println("#"+test_case+" "+res);
        }
    }
}