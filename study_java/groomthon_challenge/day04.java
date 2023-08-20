import java.util.Scanner;

/*
* 문제 설명
* N개의 재료를 쌓아 햄버거를 만든다.
* 햄버거 맛은 모든 재료의 맛의 정도를 더한 값이다.
* 완벽한 햄버거를 위해 맛이 높은것부터 아래로 갈수록 같거나 감소해야한다.
* 만약 완벽하지 않은 햄버거면 0을 출력한다.
* 1 <= N <= 1000
* 1 <= ki <= 10^6
* */

public class Main {
    /*
    * 정렬의 조건은 가장 높은 정수를 기준으로, 왼쪽이나 오른쪽으로 갈 수록 정수의 값이 같거나 감소되어야 합니다.
    * 1. 가장 큰 값의 위치 찾기
    * 2. 큰 값 위치를 기준으로 앞의 값들은 오름차순인지, 뒤의 값들은 내림차순인지 확인
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // 입력을 받기 위해 Scanner 객체 생성

        // N 입력 받기
        int n = Integer.parseInt(sc.nextLine());

        // 배열 입력 받기
        String[] arrStr = sc.nextLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for (String s : arrStr) {
            arr.add(Integer.parseInt(s));
        }

        // 최대값과 그 인덱스 찾기
        int maxIndex = arr.indexOf(Collections.max(arr));

        // 좌측 리스트와 우측 리스트 생성
        ArrayList<Integer> left = new ArrayList<>(arr.subList(0, maxIndex));
        ArrayList<Integer> right = new ArrayList<>(arr.subList(maxIndex, n));

        // 좌측 리스트는 오름차순, 우측 리스트는 내림차순으로 정렬
        Collections.sort(left);
        Collections.sort(right, Collections.reverseOrder());

        // 좌측 리스트와 우측 리스트 합치기
        ArrayList<Integer> sortedArr = new ArrayList<>();
        sortedArr.addAll(left);
        sortedArr.addAll(right);

        // 리스트 비교 후 결과 출력
        if (sortedArr.equals(arr)) {
            // 스트림으로 변환 후 Integer에서 int로 변환 후 sum으로 모든 요소 더함
            int sum = sortedArr.stream().mapToInt(Integer::intValue).sum();
            System.out.println(sum);
        } else {
            System.out.println(0);
        }
    }
}