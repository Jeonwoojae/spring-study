import java.util.Scanner;

/*
* 문제 설명
*
* */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int result = 0;
        for (int i = 0; i < T; i++) {
            String[] strArr = sc.nextLine().split(" ");
            int firstNum = Integer.parseInt(strArr[0]);
            String command = strArr[1];
            int secondNum = Integer.parseInt(strArr[2]);
            if (command.equals("+")) result += (firstNum + secondNum);
            else if (command.equals("-")) result += (firstNum - secondNum);
            else if (command.equals("*")) result += (firstNum * secondNum);
            else result += (firstNum / secondNum);
        }

        System.out.println(result);
    }
}