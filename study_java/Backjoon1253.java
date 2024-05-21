import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int result = 0;
        for(int i = 0 ; i < N ; i++){
            int left = 0;
            int right = N-1;
            while(true){
                // 현재 i의 위치에 있는 경우
                if(left == i) left++;
                else if(right == i) right--;

                // 포인터가 넘어갔으면 종료
                if(left >= right) break;

                // 정렬이 되어 있으므로, 합이 더 크다면 더 작은 수를 더하도록
                if(numbers[left] + numbers[right] > numbers[i]) right--;
                // 합이 작다면 더 큰수를 더하도록
                else if(numbers[left] + numbers[right] < numbers[i]) left++;
                else{
                    // 합과 값이 같다면 ++
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
