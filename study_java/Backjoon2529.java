import java.util.*;
public class Main {
    // 이전 순열을 찾는 함수
    static boolean prev_permutation(int[] a) {
        int i = a.length-1;
        // 뒤에서 부터 탐색하여 현재 원소가 이전 원소보다 큰 위치를 찾음
        while (i > 0 && a[i-1] <= a[i]) {
            i -= 1;
        }

        // 전체 배열이 오름차순일 경우 이전 순열이 존재하지 않음
        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        // 뒤에서부터 탐색하며, a[i-1]보다 작은 원소를 찾음
        while (a[j] >= a[i-1]) {
            j -= 1;
        }

        // a[i-1]과 a[j]를 교환
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        // i부터 끝까지의 부분을 뒤집음
        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        // 이전 순열이 존재하면 true 반환
        return true;
    }

    // 다음 순열을 찾는 함수
    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        // 뒤에서부터 탐색하며, 현재 원소가 이전 원소보다 작은 위치를 찾음
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        // 전체 배열이 내림차순일 경우 다음 순열이 존재하지 않음
        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        // 뒤에서부터 탐색하며, a[i-1]보다 큰 원소를 찾음
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        // a[i-1]과 a[j]를 교환
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        // i부터 끝까지의 부분을 뒤집음
        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        // 다음 순열이 존재하면 true 반환
        return true;
    }

    // 주어진 순열이 부등호 배열에 부합하는지 체크하는 함수
    static boolean check(int[] perm, char[] a) {
        for (int i=0; i<a.length; i++) {
            if (a[i] == '<' && perm[i] > perm[i+1]) {
                return false;
            }
            if (a[i] == '>' && perm[i] < perm[i+1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        char[] a = new char[k];
        for (int i=0; i<k; i++) {
            a[i] = sc.next().charAt(0);
        }
        int[] small = new int[k+1];
        int[] big = new int[k+1];
        for (int i=0; i<=k; i++) {
            small[i] = i;
            big[i] = 9-i;
        }
        // 다음 순열을 찾으며 부등호 배열에 부합하는지 체크
        do {
            if (check(small, a)) {
                break;
            }
        } while(next_permutation(small));

        // 이전 순열을 찾으며, 부등호 배열에 부합하는지 체크
        do {
            if (check(big, a)) {
                break;
            }
        } while(prev_permutation(big));

        // 결과 출력
        for (int i=0; i<big.length; i++) {
            System.out.print(big[i]);
        }
        System.out.println();
        for (int i=0; i<small.length; i++) {
            System.out.print(small[i]);
        }
        System.out.println();
    }
}