import java.util.Scanner;

public class Main1157 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        sc.close();

        String b = a.toUpperCase();
        int[] list = new int[26];
        for (int i=0;i<b.length();i++){
            int index = b.charAt(i)-'A';
            list[index]++;
        }
        int maxindex = 0;
        char ans = '?';
        int check = 0;

//        이부분부터 명확히

        for (int i=0;i<list.length;i++){
            if (list[i]>list[maxindex]) {
                maxindex = i;
                check = 0;
            }
            else if (i!=0&&list[i]==list[maxindex]) {
                check = 1;
            }
        }
        if (check != 1) ans = (char) (maxindex+'A');


        System.out.println(ans);
    }
}