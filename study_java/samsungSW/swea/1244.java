import java.io.*;
import java.util.*;

public class Solution {
    static String[] arr;
    static int max, chance;

    public static void main(String[] args) throws FileNotFoundException {
        //System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1 ; test_case <= T ; test_case++) {
            arr = sc.next().split("");
            chance = sc.nextInt();

            max = 0;
            // 시간초과 최적화
            if(arr.length < chance) {	// swap 횟수가 자릿수보다 클 때
                chance = arr.length;	// 자릿수만큼만 옮겨도 전부 옮길 수 있음
            }
            dfs(0, 0);
            System.out.println("#" + test_case + " " + max);
        }
    }
    static void dfs(int start, int cnt) {
        if(cnt == chance) {
            String result = "";
            for(String s : arr)
                result += s;
            max = Math.max(max, Integer.parseInt(result));
            return;
        }
        for(int i = start; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                // swap
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                dfs(i, cnt + 1);	// 깊이 +1
                // 다시 swap 해서 되돌림
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}