import java.util.*;
import java.io.*;

class Title {
    String name;
    int powerLimit;

    public Title(String name, int powerLimit) {
        this.name = name;
        this.powerLimit = powerLimit;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 칭호의 개수
        int m = Integer.parseInt(st.nextToken());  // 캐릭터의 개수

        List<Title> titles = new ArrayList<>(n);

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            titles.add(new Title(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            int index = findTitleIndex(titles, power);
            bw.write(titles.get(index).name + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int findTitleIndex(List<Title> titles, int power) {
        int left = 0;
        int right = titles.size() - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (titles.get(mid).powerLimit >= power) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
