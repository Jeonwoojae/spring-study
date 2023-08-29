import java.util.Scanner;

/*
* 현재 N의 최댓값이 10,000,000으로 매우 커 시간 초과할 수 있음.
* 이런 상환에는 O(n log n)으로도 초과하므로 O(n)의 알고리즘을 사용해야한다.
* 자주 사용하는 방법이 투 포인터. 시작 인덱스와 종료 인덱스를 투 포인터로 지정한 후 문제를 풀 수 있다.
* */

public class Backjoon2018 {
    /*
    * 슈도코드
    * N 변수 저장
    * 사용변수 초기화 (count = 1(자기자신), start_index = 1, end_index = 1_
    * while(end_index != N)
    *   if(sum == N) count 증가, end_index 증가, sum값 변경
    *   else if(sum > N) sum값 변경, start_index 증가
    *   else if(sum < N) end_index 증가, sum값 변경
    * */
    public static void main(String[] args){
        Scanner sc = new Scanner(system.in);
        int N = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while(end_index!=N){
            if(sum == N){
                count++;
                end_index++;
                sum += end_index;
            } else if(sum>N){
                // 연산 순서 주의
                sum = sum - start_index;
                start_index++;
            } else{
                end_index++; sum += end_index;
            }
            System.out.println(count);
        }
    }
}