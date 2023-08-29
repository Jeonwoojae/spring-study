import java.util.Scanner;

/*
* 문제 설명
*
* */

// Comparable을 구현해야 비교 가능.
class Pair implements Comparable<Pair> {
    int bits;
    int num;

    public Pair(int bits, int num) {
        this.bits = bits;
        this.num = num;
    }

    // Comparable 인터페이스는 정의해야함.
    // 해당 자료형의 정렬 조건
    public int compareTo(Pair o) {
        // 또 다른 객체 o와 비교
        // 반환이 true이면 o보다 기존의 Pair가 큰것.
        if (this.bits == o.bits) {
            // 비트 수가 같으면 10진수끼리 비교
            // 양수면 true
            return o.num - this.num;
        } else {
            // 비트 수가 다르면 비트 수 끼리 비교.
            return o.bits - this.bits;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Pair> pairs = new ArrayList<>();

        for(int i = 0; i < N; ++i) {
            int num = sc.nextInt();
            int bits = Integer.bitCount(num);  // 정수를 2진수로 변경하는 방법
            /*
            * 다른 N 진수로 변경하기. toString을 사용하기 위해 정수형 변환이 필요.
            * int decimalNumber = 15;
            * Strng binaryNumber = Integer.toString(decimalNumber, 2);
            * */

            // 2진수에서 1의 개수와 10진수로 Pair 객체 생성
            pairs.add(new Pair(bits, num));
        }

        // 선언한 comapreTo 조건에 의해 정렬
        Collections.sort(pairs);

        // 데이터 중 가장 마지막(가장 큰 데이터)을 출력
        System.out.println(pairs.get(K-1).num);
    }
}