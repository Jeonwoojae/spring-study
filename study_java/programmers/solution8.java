import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        List<String> playerList = new ArrayList<>(Arrays.asList(players));

        for (String calling : callings) {
            int idx = playerList.indexOf(calling);
            if (idx > 0) {
                Collections.swap(playerList, idx-1, idx);
            }
        }

        return playerList.toArray(new String[0]);
    }
}