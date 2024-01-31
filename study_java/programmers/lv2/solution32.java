import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> messages = new ArrayList<>();  // 출력할 메세지들 저장.
        HashMap<String, String> userInfo = new HashMap<>();  // uid에 대응되는 닉네임 저장.
        for(String words : record) {
            String[] wordsList = words.split(" ");  //[0]:접속/퇴장/변경 [1]: uid [2]: 현재 닉네임
            // 사용자 정보를 저장 OR 업데이트
            if(!wordsList[0].equals("Leave")) {
                userInfo.put(wordsList[1], wordsList[2]);
            }
        }

        // 기록에 따라 메세지로 변환
        for(String words : record) {
            String[] wordsList = words.split(" ");
            if(wordsList[0].equals("Enter")) {
                messages.add(userInfo.get(wordsList[1]) + "님이 들어왔습니다.");
            }
            if(wordsList[0].equals("Leave")) {
                messages.add(userInfo.get(wordsList[1]) + "님이 나갔습니다.");
            }
        }

        return messages.toArray(new String[0]);
    }
}
