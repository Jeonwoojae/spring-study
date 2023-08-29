import java.util.Scanner;

/*
* P와 S의 길이가 1,000,000으로 매우 크기 때문에 O(n)으로 해결해야 함.
* 이때 부분 문자열의 길이가 P이므로 슬라이딩 윈도우를 사용하여 해결할 수 있다.
* 슬라이딩 윈도우는 투포인터와 다르게 크기가 그대로 유지된다.
*
* */
public class Backjoon12891 {
    /*
    * 슈도코드
    * // 데이터 저장
    * S(문자열 크기) P(부분 문자열의 크기)
    * A(문자열 데이터)
    * checkArr(비밀번호 체크 배열)
    *
    * // 변수 선언
    * myArr(현재 상태 배열)
    * checkSecret(몇개의 문자와 관련된 개수를 충족했는지 판단하는 변수
    * P 범위(0 ~ P-1)만큼 S 배열에 적용하고, 유효한 비밀번호인지 판단
    * for(i를 P에서 S까지 반복)
    * {
    *   j 선언 (i-P)
    * }
    * */
    static int myArr[];
    static int checkArr[];
    static int checkSecret;
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0;
        checkArr[] = new int[4];
        myArr = new int[4];
        char A[] = new char[S];
        checkSecret = 0;

        // 비밀번호 체크배열 저장
        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0){
                checkSecret++;
            }
        }

        for(int i=0; i<P; i++){ // 부분문자열 처음 받을 때 세팅
            Add(A[i]);
        }

        if(checkSecret == 4) Result++;

        // 슬라이드 윈도우
        for(int i=P; i<S ;i++){
            int j = i-P; // 맨 오른쪽이 j, 왼쪽이 i
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4) Result++;
        }
        System.out.println(Result);
        bf.close();
    }
    private static void Remove(char c){
        switch (c){
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c){
        switch (c){
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}