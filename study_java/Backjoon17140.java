import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int m = 3;
        int[][] a = new int[100][100];
        int r = sc.nextInt()-1; // 문제에서 인덱스 시작을 1로 하고있기 때문에 맞춰준다.
        int c = sc.nextInt()-1;
        int k = sc.nextInt();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        // 계산하지 않아도 되는 경우 바로 종료
        if (a[r][c] == k) {
            System.out.println(0);
            System.exit(0);
        }

        // 최대 100번까지 반복
        for (int t=1; t<=100; t++) {
            if (n >= m) {
                // 행의 개수 >= 열의 개수이면 R연산 수행
                int mm = m;
                for (int i=0; i<n; i++) {
                    // 각 숫자의 개수를 저장
                    HashMap<Integer, Integer> d = new HashMap<>();
                    for (int j=0; j<m; j++) {
                        if (a[i][j] == 0) continue;
                        int val = 0;
                        if (d.containsKey(a[i][j])) {
                            val = d.get(a[i][j]);
                        }
                        val += 1;
                        d.put(a[i][j], val);
                    }
                }
                // 저장한 개수로 새로운 배열 생성
                ArrayList<Pair> v = new ArrayList<>();
                for (Entry<Integer, Integer> e : d.entrySet()) {
                    v.add(new Pair(e.getKey(), e.getValue()));
                }
                Collections.sort(v);
                // 배열을 가장 큰 기준에 맞춰 채우고, 없는 값은 0으로 저장
                int l = Math.min((int)v.size(), 50);
                for (int j=0; j<l; j++) {
                    a[i][j*2] = v.get(j).num;
                    a[i][j*2+1] = v.get(j).cnt;
                }
                for (int j=l*2; j<100; j++) {
                    a[i][j] = 0;
                }
                if (mm < (int)v.size()*2) {
                    mm = (int)v.size()*2;
                }
                m = mm;
            } else {
                // 행의 개수 < 열의 개수이면 C연산 수행
                int nn = n;
                for (int j=0; j<m; j++) {
                    HashMap<Integer, Integer> d = new HashMap<>();
                    for (int i=0; i<n; i++) {
                        if (a[i][j] == 0) continue;
                        int val = 0;
                        if (d.containsKey(a[i][j])) {
                            val = d.get(a[i][j]);
                        }
                        val += 1;
                        d.put(a[i][j], val);
                    }
                    ArrayList<Pair> v = new ArrayList<>();
                    for (Entry<Integer, Integer> e : d.entrySet()) {
                        v.add(e.getKey(), e.getValue());
                    }
                    Collections.sort(v);
                    int l = Math.min((int)v.size(), 50);
                    for (int i=0; i<l; i++) {
                        a[i*2][j] = v.get(i).num;
                        a[i*2+1][j] = v.get(i).cnt;
                    }
                    for (int i=l*2; i<100; i++) {
                        a[i][j] = 0;
                    }
                    if (nn < (int)v.size()*2) {
                        nn = (int)v.size()*2;
                    }
                }
                n = nn;
            }
            // 조건을 만족하면 종료
            if (a[r][c] == k) {
                System.out.println(t);
                System.exit(0);
            }
        }
        System.out.println(-1);  // 100번 해도 만족하지 못하면 -1을 리턴
    }
}