import java.util.*;
import java.io.*;

class Room {
    int lv;
    boolean isStart = false; // 초기화
    List<Player> playerList;
    int maxPlayer;

    public Room (Player player, int maxValue) {
        this.lv = player.lv; // player의 레벨을 기준으로 lv 초기화
        this.playerList = new ArrayList<>();
        this.playerList.add(player);
        this.maxPlayer = maxValue;
        if (playerList.size() >= maxPlayer) isStart = true; // 방이 꽉 찼을 때 게임 시작
    }
    public boolean enter(Player player) {
        if (maxPlayer > playerList.size() && !isStart) {
            playerList.add(player);
            if (playerList.size() >= maxPlayer) isStart = true; // 입장할 때 마다 검사
            return true;
        } else {
            return false;
        }
    }

    public void print(BufferedWriter bw) throws IOException {
        if (isStart) {
            bw.write("Started!");
        } else {
            bw.write("Waiting!");
        }
        bw.newLine();
        Collections.sort(playerList);
        for (Player player : playerList) {
            bw.write(Integer.toString(player.lv));
            bw.write(" ");
            bw.write(player.id);
            bw.newLine();
        }
    }
}

class Player implements Comparable<Player>{
    int lv;
    String id;

    public Player(int lv, String id) {
        this.lv = lv;
        this.id = id;
    }
    public int compareTo(Player o) {
        return this.id.compareTo(o.id); // 닉네임(사전순) 비교
    }

    public boolean tryEnter(List<Room> roomList) {
        for (Room room : roomList) {
            if (!room.isStart && (this.lv <= room.lv+10 && this.lv >= room.lv-10)) {
                if (room.enter(this)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Room makeNewRoom(int maxValue) {
        return new Room(this, maxValue);
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> roomList = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            Player player = new Player(l, n);

            // 만약 입장 가능한 방이 없으면 새로운 방을 생성
            if (!player.tryEnter(roomList)) {
                roomList.add(player.makeNewRoom(m));
            }
        }

        for (Room room : roomList) {
            room.print(bw);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
