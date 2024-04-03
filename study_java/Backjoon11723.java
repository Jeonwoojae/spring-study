import java.util.*;
import java.io.*;

public class Main {
    static boolean[] a;
    public static StringBuilder doSomething(String mode, String value) {
        StringBuilder output = new StringBuilder();
        if (mode.equals("add")) {
            a[Integer.parseInt(value)] = true;
        } else if (mode.equals("remove")) {
            a[Integer.parseInt(value)] = false;
        } else if (mode.equals("check")) {
            if (a[Integer.parseInt(value)]) {
                output.append(1).append('\n');
            } else {
                output.append(0).append('\n');
            }
        } else if (mode.equals("toggle")) {
            a[Integer.parseInt(value)] = !a[Integer.parseInt(value)];
        } else if (mode.equals("all")) {
            Arrays.fill(a, true);
        } else { // mode.equals("empty")
            Arrays.fill(a, false);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        a = new boolean[21];
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            result.append(doSomething(line[0], line.length > 1 ? line[1] : ""));
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
