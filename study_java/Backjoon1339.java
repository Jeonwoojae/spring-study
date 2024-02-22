import java.util.*;
public class Main {
    // 다음 순열을 찾는 함수
    static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        // 뒤에서부터 탐색하여 현재 원소가 이전 원소보다 작은 위치를 찾는다.
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        // 전체 배열이 내림차순일 경우 다음 순열이 존재하지 않음
        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        // 뒤에서부터 탐색하여 a[i-1] 보다 큰 원소를 찾는다.
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        // a[i-1]과 a[j]를 교환
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        // i부터 끝까지의 부분을 뒤집음
        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        // 다음 순열이 존재하면 true를 반환
        return true;
    }

    // 알파벳에서 대응하는 숫자를 저장하는 배열
    static int[] alpha = new int[256];

    // 각 문자에 대응하는 숫자를 이용하여 단어의 합을 계산하는 함수
    static int calc(String[] a, Character[] letters, int[] d) {
        int m = letters.length;
        int sum = 0;
        // 각 문자에 대응하는 숫자를 저장
        for (int i=0; i<m; i++) {
            alpha[letters[i]] = d[i];
        }
        // 각 단어의 합을 계산
        for (String s : a) {
            int now = 0;
            for (char x : s.toCharArray()) {
                now = now * 10 + alpha[x];
            }
            sum += now;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[n];
        HashSet<Character> s = new HashSet<>();

        for (int i=0; i<n; i++) {
            a[i] = sc.next();
            for (char x: a[i].toCharArray()) {
                s.add(x);
            }
        }
        Character[] letters = s.toArray(new Character[s.size()]);
        int m = letters.length;
        int[] d = new int[m];
        for (int i=0; i<m; i++) {
            d[i] = 9-i;
        }
        Arrays.sort(d);
        int ans = 0;

        // 다음 순열을 찾으면서, 각 문자에 대응하는 숫자를 이용하여 단어의 합을 계산
        do {
            int now = calc(a, letters, d);
            if (ans < now) {
                ans = now;
            }
        } while(nextPermutation(d));
        System.out.println(ans);
    }
}