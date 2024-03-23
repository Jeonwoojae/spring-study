import java.util.*;
public class Main {
    // s의 부분 수열의 갯수가 2^N인데 N<=20이기 떄문에 모두 계산이 가능하다.

    static boolean[] c = new boolean[20*100000+10];  // 합의 결과를 저장
    static int[] a = new int[20];  // 입력 받은 숫자를 저장
    static int n;
    static void go(int i, int sum) {
        if (i==n) {
            // 인덱스가 배열의 크기를 넘어갈 경우 재귀 종료
            c[sum] = true;
            return;
        }
        go(i+1, sum+a[i]);  // 현재 인덱스의 값을 합하는 경우
        go(i+1,sum);  // 현재 인덱스의 값을 합하지 않는 경우
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        go(0,0);
        for(int i=1;;i++) {
            if(c[i] == false) {
                System.out.println(i);
                break;
            }
        }

    }
}