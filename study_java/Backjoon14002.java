import java.util.*;

public class Main {
    static void go(int p) {
        if (p == -1) return;
        go(index[p]);
        System.out.print(A[p] + " ");
    }
    static int[] A;
    static int[] d;
    static int[] index;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N];
        d = new int[N];
        index = new int[N];

        for(int i=0;i<N;i++) {
            A[i] = sc.nextInt();
        }

        for(int i=0;i<N;i++) {
            d[i] = 1;  // 적어도 길이는 1
            index[i] = -1;
            for(int j=0;j<i;j++) {
                // 앞의 부분에서 가장 길었던 부분 중 가장 큰 값으로 업데이트
                if(A[j] < A[i] && d[i]< d[j]+1) {
                    // 앞에서 찾은 가자 긴 부분 수열 사용
                    d[i] = d[j] + 1;
                    index[i] = j;
                }
            }
        }
        int ans = d[0];
        int p = 0;
        for (int i=0; i<N; i++) {
            if (ans < d[i]) {
                ans = d[i];
                p = i;
            }
        }
        System.out.println(ans);
        go(p);
        System.out.println();
    }
}