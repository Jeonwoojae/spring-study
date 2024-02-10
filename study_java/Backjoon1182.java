import java.util.*;
public class Main {
    public static int go(int[] a, int s, int i, int sum) {
        // a:저장된 배열, s:목표 합, i:부분 수열에서 포함할지 결정하는 인덱스. sum : 현재까지 합
        if(i == a.length) {
            if (sum == s) {
                // 정답을 찾은 경우
                return 1;
            } else {
                // 불가능한 경우
                return 0;
            }
        }
        // 다음 인덱스에 탐색
        // 현재 숫자를 추가했거나 추가하지 않았을 때를 계산
        return go(a,s,i+1,sum+a[i]) + go(a,s,i+1,sum);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = go(a,s,0,0);
        if (s==0) {
            ans -= 1;
        }
        System.out.println(ans);
    }
}