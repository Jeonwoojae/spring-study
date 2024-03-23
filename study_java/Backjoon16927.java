import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int [][]a = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                a[i][j] = sc.nextInt();
            }
        }

        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        int groupn = Math.min(n,m)/2;
        for(int k=0;k<groupn;k++) {
            ArrayList<Integer> group = new ArrayList<>();
            for(int i=k;i<m-k;i++) {
                group.add(a[k][i]);
            }
            for(int j=k+1;j<n-k-1;j++) {
                group.add(a[j][m-k-1]);
            }
            for(int i=m-k-1;i>k;i--) {
                group.add(a[n-k-1][i]);
            }
            for(int j=n-k-1;j>k;j--) {
                group.add(a[j][k]);
            }
            groups.add(group);
        }

        // 반시계 회전
        for(int k=0;k<groupn;k++) {
            ArrayList<Integer> group = groups.get(k);
            int len = group.size();
            int index = r % len;  // 얼마나 이동할지
            for(int i=k;i<m-k;i++,index = (index+1)%len) {
                a[k][i] = group.get(index);
            }
            for(int j=k+1;j<n-k-1;j++,index = (index+1)%len) {
                a[j][m-k-1] = group.get(index);
            }
            for(int i=m-k-1;i>k;i--,index = (index+1)%len) {
                a[n-k-1][i] = group.get(index);
            }
            for(int j=n-k-1;j>k;j--,index = (index+1)%len) {
                a[j][k] = group.get(index);
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}