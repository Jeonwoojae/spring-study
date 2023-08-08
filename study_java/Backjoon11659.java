import java.util.Scanner;

/*
* 항상 최악의 경우를 계산해야함.
* 10만개 배열이 들어왔고, 1~10만개를 구한다면
* 1번의 질의당 10만번의 연산이 필요하다.
* 10만*10만 하면 1억이 넘어 시간 초과할 것.
*
* 주어진 배열은 항상 고정되어 있음.
* 질의 갯수가 많음.
* 따라서 합배열로 해결하는게 좋다.
*
* */

public class Backjoon11659 {
    public static void main(String[] args){
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer =
                new StringTokenizer(bufferedReader.readLine());
        int suNo = Integer.parseInt(stringTokenizer.nextToken);
        int quizNo = Integer.parseInt(stringTokenizer.nextToken);

//        습관적으로 long 사용이 좋다. 결과가 클 수 있으니까
        long[]S = new long[suNo + 1];
        stringTokenizer =
                new StringTokenizer(bufferedReader.readLine());

        for(int i=1; i<= suNo; i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken);
        }
        for(int q=0;q<quizNo;q++){
            stringTokenizer =
                    new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken);
            int j = Integer.parseInt(stringTokenizer.nextToken);
            System.out.println(S[j]-S[i-1]);
        }
    }
}