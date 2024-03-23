import java.util.*;
class Pair {
    public int min;
    public int max;
    Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
public class Main {
    static Pair calc(int[] a, int index, int cur, int plus, int minus, int mul, int div) {
        int n = a.length;
        if(index==n) {
            // 만약 끝까지 탐색했다면 종료값 생성
            return new Pair(cur, cur);
        }
        ArrayList<Pair> res = new ArrayList<Pair>();
        // 현재 위치에서 최대값과 최소값 탐색
        if (plus>0) {
            res.add(calc(a, index+1, cur+a[index], plus-1, minus,mul,div));
        }
        if (minus>0) {
            res.add(calc(a, index+1, cur-a[index],plus,minus-1,mul,div));
        }
        if (mul>0) {
           res.add(calc(a, index+1, cur*a[index],plus,minus,mul-1,div));
        }
        if (div>0) {
            res.add(calc(a, index+1, cur/a[index],plus,minus,mul,div-1));
        }
        Pair ans = res.get(0);
        // 값들 중 최소값과 최대값을 가진 Pair를 반환
        for (Pair p : res) {
            if(ans.max<p.max) {
                ans.max = p.max;
            }
            if(ans.min>p.min) {
                ans.min = p.min;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();
        Pair ans = calc(nums, 1, nums[0], plus, minus, mul, div);
        System.out.println(ans.max);
        System.out.println(ans.min);
    }
}