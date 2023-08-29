import java.util.Scanner;

/*
* 절댓값 힙이란?
* 1. 배열에 정수 x(x != 0)을 넣는다.
* 2. 배열에서 절댓값이 가장 작은 값을 출력한 후 그 값을 배열에서 제거한다.
* 절댓값이 가장 작은 값이 여러개일 경우에는 그중 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
* 이런 문제를 풀때는 꼼꼼히 이해하면 쉽다. 문제 파악이 중요!
*
* 데이터가 삽입될 때마다 정렬이 필요하므로 우선순위 큐로 문제를 해결.
* 또 절댓값으로 정렬해야하므로 정렬을 커스터마이징 해야함
* */
public class Backjoon11286 {
    /*
    * N(질의 요청 개수)
    * 우선순위 큐 선언
    *   절댓값 기준으로 정렬되도록 설정
    *   단, 절댓값이 같으면 음수 우선 정렬
    * for(N 만큼 반복)
    * {
    *   요청이 0일 때: 큐가 비었으면 0, 아니면 front값 출력
    *   요청이 1일 때: 새로운 데이터를 큐에 추가
    * */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1,o2)->{

            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            // 절댓값이 같은 경우 음수 우선
            if(first_abs == second_abs){
                return o1 > o2 ? 1 : -1;
            }

            // 절댓값 작은 데이터 우선
            return first_abs - second_abs;
        });

        for(int i=0; i<N; i++){
            int request = Integer.parseInt(br.readLine());
            if (request == 0){
                if(myQueue.isEmpty()){
                    System.out.println("0");
                }else {
                    System.out.println(myQueue.poll());
                }
            }else {
                myQueue.add(request);
            }
        }
    }
}