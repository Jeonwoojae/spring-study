import java.util.Scanner;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int dayCount = sc.nextInt();
            Integer[] priceList = new Integer[dayCount];

            for(int i=0;i<dayCount;i++) {
                priceList[i] = sc.nextInt();
            }

            long highPrice = priceList[priceList.length - 1];
            List<Integer> buyList = new ArrayList<>();
            long money = 0;
            for(int i=priceList.length-1;i>=1;i--) {
                // 지금 가격이 전보다 비싸거나 같을 때
                // 전날 산것으로 저장
                if (priceList[i] >= priceList[i-1]) {
                    buyList.add(priceList[i-1]);
                    // 전날이 더 비싸면 계산
                } else if (priceList[i]<priceList[i-1]){
                    for(int j=0;j<buyList.size();j++){
                        money = money + highPrice - buyList.get(j);
                    }
                    buyList.clear();
                    if (highPrice<priceList[i-1]) highPrice = priceList[i-1];
                    buyList.add(priceList[i-1]);
                }
            }
            // 다 수행해도 남아있으면 계산
            for(int j=0;j<buyList.size();j++){
                money = money + highPrice - buyList.get(j);
            }
            System.out.println("#"+test_case+" " + money);
        }
    }
}