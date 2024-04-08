import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password;

        while (!(password = br.readLine()).equals("end")) {
            System.out.println(isAcceptable(password) ? "<" + password + "> is acceptable." : "<" + password + "> is not acceptable.");
        }
    }

    public static boolean isAcceptable(String password) {
        boolean containsVowel = false; // 모음 포함 여부
        int consecutiveVowels = 0; // 연속된 모음 수
        int consecutiveConsonants = 0; // 연속된 자음 수
        char lastChar = ' '; // 이전 문자

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            // 모음 검사
            if (isVowel(c)) {
                containsVowel = true;
                consecutiveVowels++;
                consecutiveConsonants = 0;
            } else {
                consecutiveVowels = 0;
                consecutiveConsonants++;
            }

            // 모음이 3개 혹은 자음이 3개 연속으로 오는지 검사
            if (consecutiveVowels > 2 || consecutiveConsonants > 2) {
                return false;
            }

            // 같은 글자가 연속적으로 두 번 오는지 검사 (단, ee 와 oo는 허용)
            if (c == lastChar && c != 'e' && c != 'o') {
                return false;
            }

            lastChar = c;
        }

        // 모음 하나를 반드시 포함하는지 검사
        return containsVowel;
    }

    // 모음인지 검사하는 함수
    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
