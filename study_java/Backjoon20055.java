import java.util.*;
public class Main {
    static void rotate(int[] a) {
        // 회전 시 맨 끝칸은 첫칸으로 이동하도록 한다.
        int temp = a[a.length - 1];
        for (int i=a.length - 1; i>0;i--) {
            a[i] = a[i-1];
        }
        a[0] = temp;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[2*n];
        // 0이 올리는 위치, n이 내리는 위치
        for (int i=0;i<2*n;i++) {
            // 각 위치의 내구도 저장
            a[i] = sc.nextInt();
        }
        int[] box = new int[2*n];
        int zero = 0; // 내구도가 0인 위치의 갯수
        for (int t=1;;t++) {
            // t = 단계
            // 1. 벨트가 로봇과 함께 컨베이어 회전
            rotate(a);
            rotate(box);

            // 2. 가장 먼저 벨트에 올라간 로봇부터(끝에서 부터) 벨트 회전 방향으로 한칸 이동할 수 있다.
            // 박스가 내리는 위치에 도달하면 즉시 내린다.
            if (box[n-1] == 1) {
                box[n-1] = 0;
            }
            for (int i=n-2;i>=0;i--) {
                if (box[i] == 1) {
                    // 2-1. 앞에 박스가 없고 앞의 컨테이너 내구도가 남았다면 이동
                    if (box[i+1] == 0 && a[i+1] > 0) {
                        box[i+1] = 1;
                        box[i] = 0;
                        a[i+1] -= 1;  // 이동 시 내구도 감소
                        // 내구도가 0이라면 count
                        if (a[i+1] == 0) {
                            zero += 1;
                        }
                    }
                }
            }
            // 이동 후에도 박스가 내리는 위치에 도달하면 즉시 내린다.
            if (box[n-1] == 1) {
                box[n-1] = 0;
            }
            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if (a[0] > 0) {
                box[0] = 1;
                a[0] -= 1;
                if (a[0] == 0) {
                    zero += 1;
                }
            }
            // 4. 내구도 0인 칸의 갯수가 k개 이상이면 종료
            if (zero >= k) {
                System.out.println(t);
                break;
            }
        }
    }
}