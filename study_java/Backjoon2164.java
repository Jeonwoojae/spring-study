import java.util.Scanner;

/*
* 1. poll을 수행하여 맨 앞의 카드를 버린다.
* 2. 과정 에 이어 바로 add를 수행해 맨 앞의 카드를 가장 아래로 옮긴다.
* 3. 큐의 크기가 1이 될 때까지 과정 1~2를 반복한다
* */
public class Backjoon2164 {
    /*
    * N(카드의 개수) myQueue(카드 저장 자료구조)
    * for(카드의 개수만큼 반복)
    * {
    *   큐에 카드 저장하기.
    * }
    * while(카드가 1장 남을 떄 까지)
    * {
    *   맨위의 카드를 버림
    *   맨위의 카드를 가장 아래의 카드 앞으로 이동
    * }
    * 마지막으로 남은 카드 출력
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();
        for(int i=1; i<=N; i++){
            myQueue.add(i);
        }
        while(myQueue.size()>1){
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }
        System.out.println(myQueue.poll());
    }
}