import java.util.*;
public class Main {
    // 각 숫자별 세그먼트 정보
    /*
    *    -     // 0번 세그먼트
        | |    // 1번 세그먼트 (왼쪽), 2번 세그먼트 (오른쪽)
         -     // 3번 세그먼트
        | |    // 4번 세그먼트 (왼쪽), 5번 세그먼트 (오른쪽)
         -     // 6번 세그먼트
    * */
    static final int[][] c = {
            {1,1,1,0,1,1,1},
            {0,0,1,0,0,1,0},
            {1,0,1,1,1,0,1},
            {1,0,1,1,0,1,1},
            {0,1,1,1,0,1,0},
            {1,1,0,1,0,1,1},
            {1,1,0,1,1,1,1},
            {1,0,1,0,0,1,0},
            {1,1,1,1,1,1,1},
            {1,1,1,1,0,1,1}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        String n = sc.next();
        int m = n.length();
        // 숫자마다 5칸씩 차지한다.
        for (int i=0; i<5; i++) {
            // 가로 세그먼트 그리기
            if (i == 0 || i == 2 || i == 4) {
                for (int j=0; j<m; j++) {
                    int now = n.charAt(j)-'0';
                    if (j != 0) {
                        System.out.print(" ");
                    }
                    System.out.print(" ");
                    // 가로 세그먼트가 필요한 경우.
                    if ((i == 0 && c[now][0] == 1) || (i == 2 && c[now][3] == 1) || (i == 4 && c[now][6] == 1)) {
                        for (int k=0; k<s; k++) {
                            System.out.print("-");
                        }
                    } else {
                        for (int k=0; k<s; k++) {
                            System.out.print(" ");
                        }
                    }
                    System.out.print(" ");
                }
                System.out.println();
            } else {
                for (int l=0; l<s; l++) {
                    for (int j=0; j<m; j++) {
                        int now = n.charAt(j) - '0';
                        if (j != 0) {
                            System.out.print(" ");
                        }
                        if ((i == 1 && c[now][1] == 1) || (i == 3 && c[now][4] == 1)) {
                            System.out.print("|");
                        } else {
                            System.out.print(" ");
                        }
                        for (int k=0; k<s; k++) {
                            System.out.print(" ");
                        }
                        if ((i == 1 && c[now][2] == 1) || (i == 3 && c[now][5] == 1)) {
                            System.out.print("|");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        }

    }
}
