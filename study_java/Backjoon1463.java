import java.util.*;

// ------------------------------------------ Bottom-Up 방식
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        d[1] = 0;
        for (int i=2; i<=n; i++) {
            d[i] = d[i-1] + 1;
            if (i%2 == 0 && d[i] > d[i/2] + 1) {
                d[i] = d[i/2] + 1;
            }
            if (i%3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i/3] + 1;
            }
        }
        System.out.println(d[n]);
    }
}

// ---------------------------------------- Top-Bottom 방식
public class Main {
    /*
    * 가능한 연산은 -1, /2, /3이 있다.
    * */
    public static int[] array;
    public static int findMin(int a) {
        // 1이거나 배열에 기록이 있으면 해당 값을 반환
        if(a == 1) return 0;
        if(array[a]>0) return array[a];

        // 세가지 연산들을 수행하여 최소 값을 찾는다.
        // 큰수로 나눌수록, -1을 적게 할 수록 최소 값이기 때문에 오래 걸리는 것 순으로 array의 값을 업데이트한다.
        array[a] = findMin(a-1) + 1;
        if(a%2 == 0) {
            int temp = findMin(a/2)+1;
            if(array[a]>temp) {
                array[a] = temp;
            }
        }
        if(a%3 == 0) {
            int temp = findMin(a/3)+1;
            if(array[a]>temp) {
                array[a] = temp;
            }
        }
        return array[a];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        array = new int[a + 1];

        System.out.println(findMin(a));
    }
}