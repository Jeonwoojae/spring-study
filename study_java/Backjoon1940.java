import java.util.Scanner;

public class Backjoon1546 {
    /*
    슈도코드
    * N(재료의 개수), M(갑옷이 되는 번호) 저장하기
    * for(N만큼 반복)
    {
      재료 배열 저장하기
    }
    재료 배열 정렬하기(오름차순)
    while(i<j)
    if(재료 합 < M) low_index를 한칸 위로 변경
    else if(재료 합 > M) 큰 번호 재료를 한칸 아래로 변경
    else 경우의 수 증가, 양쪽 index 변경
    * */
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new System.in);
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;
        int i = 0;
        int j = N - 1;
        while (i<j){
            if (A[i]+A[j]<M) i++;
            else if(A[i]+A[j]>M) j--;
            else{
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);

    }
}