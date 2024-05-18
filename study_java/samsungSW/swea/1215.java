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
    public static int cnt;
    public static char[][] arr;
    public static void main(String args[]) throws Exception
    {

        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=10;


        for(int t = 1; t<= T; t++)
        {
            int len = Integer.parseInt(br.readLine());
            arr = new char[8][8];
            cnt = 0;
            for (int i=0; i<8;i++) {
                arr[i] = br.readLine().toCharArray();
            }


            // 가로 탐색
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j + len - 1 < 8; j++) {
                    boolean isPalindrome = true;
                    for (int k = 0; k < len / 2; k++) {
                        if (arr[i][j + k] != arr[i][j + len - 1 - k]) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) {
                        cnt++;
                    }
                }
            }

            // 세로 탐색
            for (int j = 0; j < 8; j++) {
                for (int i = 0; i + len - 1 < 8; i++) {
                    boolean isPalindrome = true;
                    for (int k = 0; k < len / 2; k++) {
                        if (arr[i + k][j] != arr[i + len - 1 - k][j]) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) {
                        cnt++;
                    }
                }
            }

            System.out.println("#" + t + " " + cnt);
        }
    }
}