import java.util.*;

public class Main {
    static int[] a;  // 각 파일 크기를 저장하는 배열
    static int[][] d;  // d[i][j] -> i번째 파일부터 j번째 파일을 하나로 합칠 때 발생하는 최소 비용
    public static int go(int i, int j) {
        if (i==j) return 0;  // 하나의 파일만 사용하기 때문에 비용은 0
        if (d[i][j] != -1) return d[i][j];  // 이미 계산된 값은 해당 값을 반환
        int ans = -1;
        int sum = 0;
        // i부터 j까지 파일 크기의 총 합을 계산
        for (int k=i; k<=j; k++) {
            sum += a[k];
        }
        for (int k=i; k<=j-1; k++) {
            // i부터 j-1까지 가능한 모든 분할 지점에 대해 계산
            int temp = go(i,k) + go(k+1, j) + sum;
            if (ans == -1 || ans > temp) {
                // 최소 비용으로 업데이트
                ans = temp;
            }
        }
        d[i][j] = ans;
        return ans;
    }
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bf.readLine());
        while (t-- > 0) {
            int n = Integer.valueOf(bf.readLine());
            String[] nums[] = bf.readLine().split(" ");
            a = new int[n+1];
            d = new int[n+1][n+1];
            for (int i=1; i<=n; i++) {
                a[i] = Integer.valueOf(nums[i-1]);
                Arrays.fill(d[i], -1);
            }
            System.out.println(go(1,n));
        }
    }
}

// 틀린 문제 풀이 방식
public class Main {
    // 합칠 때 필요한 비용 = 두 파일 크기의 합
    // 최종적인 한 파일을 완성하는데 필요한 비용의 총 합
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt(); // 소설을 구성하는 장의 수
            int[] a = new int[k];
            for (int i=0; i<a.length; i++) {
                a[i] = sc.nextInt();  // 각 파일 크기 저장
            }
            Arrays.sort(a);
            int ans = a[0]*(a.length-1);
            for (int i=1;i<a.length;i++) {
                // 작은 것을 자주 사용해야 비용이 최소.
                // ex [a,b,c,d] -> (a+b)+(a+b+c)+(a+b+c+d) = a*3 + b+3 + c*2 + d*1
                ans += a[i]*(a.length-i);
            }
            System.out.println(ans);
        }
    }
}