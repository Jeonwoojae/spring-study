import java.util.Scanner;
import java.io.FileInputStream;
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
            int buildingCount = sc.nextInt();
            Integer[] buildingList = new Integer[buildingCount+2];
            for(int i=0; i<buildingCount; i++) {
                int height = sc.nextInt();
                buildingList[i] = height;
            }
            buildingList[buildingCount] = 0;
            buildingList[buildingCount+1] = 0;


            int result = 0;
            Integer[] window = {0,0,0,buildingList[0],buildingList[1]};
            for(int i=2;i<buildingCount;i++) {
                window[0] = window[1];
                window[1] = window[2];
                window[2] = window[3];
                window[3] = window[4];
                window[2] = buildingList[i];

                int maxHeight = Math.max(Math.max(window[0], window[1]), Math.max(window[3], window[4]));
                if (maxHeight < window[2]) {
                    result = result + window[2] - maxHeight;
                }
            }

            System.out.println("#"+T +" " + result);
        }
    }
}