import java.util.Scanner;

/*
* 문제 설명
* 프로젝트 완성을 위해 N개의 기능 개발이 필요하다.
* 각 기능에는 1번부터 N번까지 번호가 있고 i번째 기능을 개발하는데 ci분의 시간이 걸린다.
*
* 플레이어가 작업을 시작한 시간은 T시 M분이다.
* 플레이어는 1번부터 개발을 진행하며 바로 다음 기능을 개발한다.
* 모든 기능 개발을 마친 시간은?
* 1 <= N <= 100
* 0 <= T <= 23
* 0 <= M <= 59
* 0 <= ci <= 1000
*
* 입력
* 3 // 필요한 기능의 개수
* 10 10 // 현재 시각
* 50  // 기능별 걸리는 시간
* 22
* 23
* */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // 입력을 받기 위해 Scanner 객체 생성

        // N 입력 받기
        int N = Integer.parseInt(sc.nextLine());

        // 현재 시간과 분 입력 받기
        String[] time = sc.nextLine().split(" ");
        int currentHour = Integer.parseInt(time[0]);
        int currentMinute = Integer.parseInt(time[1]);

        // 각각의 분만큼 시간에 추가하기
        for (int i = 0; i < N; i++) {
            int costMinute = Integer.parseInt(sc.nextLine());
            int tempMinute = currentMinute + costMinute;
            int resultMinute = tempMinute % 60;
            int resultHour = (currentHour + tempMinute / 60) % 24;
            currentHour = resultHour;
            currentMinute = resultMinute;
        }

        // 결과 출력
        System.out.println(currentHour + " " + currentMinute);
    }
}