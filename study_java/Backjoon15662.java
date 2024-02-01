import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        char[][] a = new char[t][8];
        for(int i = 0; i <t;i++) {
            a[i] = sc.next().toCharArray();
        }

        int k = sc.nextInt();
        while(k-->0) {
            int num = sc.nextInt()-1;
            int dir = sc.nextInt();
            int[] d = new int[t]; // 각 톱니바퀴의 돌리는 정보
            d[num] = dir;
            // 돌릴 톱니 좌측 돌리기
            for(int i=num-1;i>=0;i--) {
                if(a[i+1][6]!=a[i][2]) {
                    d[i] = -d[i+1];
                } else {
                    break;
                }
            }
            // 돌릴 톱니 우측 돌리기
            for(int i=num+1;i<t;i++) {
                if(a[i-1][2] != a[i][6]) {
                    d[i] = -d[i-1];
                } else {
                    break;
                }
            }
            // 돌릴 톱니바퀴 회전
            for(int i=0;i<t;i++) {
                if(d[i] == 0) continue;
                if(d[i] == 1) {
                    // 시계 방향으로 회전
                    char temp = a[i][7];
                    for(int j=7;j>=1;j--) {
                        a[i][j] = a[i][j-1];
                    }
                    a[i][0] = temp;
                } else if(d[i] == -1) {
                    // 반시계 방향으로 회전
                    char temp = a[i][0];
                    for(int j=0;j<7;j++) {
                        a[i][j] = a[i][j+1];
                    }
                    a[i][7] = temp;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<t;i++) {
            if(a[i][0] == '1') {
                ans++;
            }
        }
        System.out.println(ans);
    }
}