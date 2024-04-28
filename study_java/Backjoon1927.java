import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Long> minQueue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long input = Long.parseLong(br.readLine());
            if (input>0) {
                minQueue.add(input);
            } else {
                if (!minQueue.isEmpty()) {
                    bw.write(Long.toString(minQueue.poll()));
                }
                else{
                    bw.write("0");
                }
                bw.newLine();
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}