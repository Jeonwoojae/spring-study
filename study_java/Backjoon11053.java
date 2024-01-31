import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] d = new int[N];

        for(int i=0;i<N;i++) {
            A[i] = sc.nextInt();
        }

        for(int i=0;i<N;i++) {
            d[i] = 1;  // 적어도 길이는 1
            for(int j=0;j<i;j++) {
                // 앞의 부분에서 가장 길었던 부분 중 가장 큰 값으로 업데이트
                if(A[j] < A[i] && d[i]< d[j]+1) {
                    // 앞에서 찾은 가자 긴 부분 수열 사용
                    d[i] = d[j] + 1;
                }
            }
        }
        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}