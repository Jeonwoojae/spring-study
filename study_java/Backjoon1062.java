import java.util.*;
public class Main {
    static boolean[] learn = new boolean[26];  // 해당 알파벳을 배웠는지 저장
    static int count(String[] words) {
        // 단어들 중 배운 알파벳으로 표현할 수 있는 단어의 개수 return
        int cnt = 0;
        for (String word : words) {
            boolean ok = true;
            for (char x : word.toCharArray()) {
                if (!learn[x-'a']) {
                    ok = false;
                    break;
                }
            }
            if (ok) cnt += 1;
        }
        return cnt;
    }
    static int go(int index, int k, String[] words) {
        // index : 현재 알파벳, k : 몇개를 더 선택할 수 있는지
        if (k < 0) return 0;  // 알파벳을 더 배울 수 없는 경우
        if (index == 26) {
            // 모든 알파벳을 고려한 경우
            return count(words);
        }
        int ans = 0;
        // index 번째 알파벳을 배우는 경우
        learn[index] = true;
        int t1 = go(index+1, k-1, words);
        learn[index] = false;
        if (ans < t1) ans = t1;

        // index번째 알파벳을 배우지 않는 경우(a,n,t,i,c는 제외)
        if (index != 'a'-'a' && index != 'n'-'a' && index != 't'-'a' && index != 'i'-'a' && index != 'c'-'a') {
            t1 = go(index+1, k, words);
            if (ans < t1) ans = t1;
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        // 0번쨰 알파벳부터 시작하여 배울 수 있는 알파벳의 개수가 m일 때 단어의 최대 개수를 출력
        System.out.println(go(0,m,words));
    }
}