import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        char[][] a = new char[4][8];  // 톱니바퀴 정보
        for (int i=0; i<n; i++) {
            a[i] = sc.next().toCharArray();
        }
        int k = sc.nextInt(); // 회전 횟수
        while(k-- > 0) {
            int num = sc.nextInt()-1;  // 회전시킨 톱니바퀴 번호
            int dir = sc.nextInt();  // 회전 방향
            int[] d = new int[n];
            d[num] = dir;
            // 돌릴 톱니 기준 좌측 톱니들 돌려야 하는지 확인
            for(int i=num-1; i>=0; i--) {
                if(a[i][2] != a[i+1][6]) {
                    // 돌려야 한다면 다음 톱니도 확인하여 돌린다.
                    d[i] = -d[i+1];
                } else {
                    // 돌리지 않아도 되면 더이상 확인하지 않아도 된다.
                    break;
                }
            }
            // 돌릴 톱니 기준 우측 톱니들 돌려야 하는지 확인
            for(int i=num+1;i<n;i++) {
                if(a[i-1][2] != a[i][6]) {
                    d[i] = -d[i-1];
                } else {
                    break;
                }
            }
            // 돌릴 톱니 정보 업데이트
            for(int i=0;i<n;i++) {
                if (d[i] == 0) continue;
                if (d[i] == 1) {
                    // 시계방향 회전
                    char temp = a[i][7];
                    for (int j=7;j>=1;j--) {
                        a[i][j] = a[i][j-1];
                    }
                    a[i][0] = temp;
                } else if (d[i] == -1) {
                    // 반시계 방향 회전
                    char temp = a[i][0];
                    for (int j=0;j<7;j++) {
                        a[i][j] = a[i][j+1];
                    }
                    a[i][7] = temp;
                }
            }
        }
        int ans = 0;
        for (int i=0;i<n;i++) {
            if(a[i][0] == '1') {
                ans |= (1<<i);
            }
        }
        System.out.println(ans);
    }
}