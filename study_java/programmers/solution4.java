import java.util.*;

class Solution {
    // id_list : 신고한 사용자, report : 신고받은 사용자, k : 정지 기준
    // answer : 각 id_list에 대해 신고 결과를 받는 횟수 int 리스트
    public int[] solution(String[] id_list, String[] report, int k) {
        // 사용자 명을 key로 사용자의 신고받은 횟수를 저장하는 변수
        Map<String, Integer> alertCountOfUser = new HashMap<>();

        // 사용자를 key로 해당 유저가 신고한 Set
        Map<String, Set<String>> usersAlertSet = new HashMap<>();

        // report에서 겹치는 신고 제외하기
        for(String words: report){
            String[] strArr = words.split(" ");
            String currentUser = strArr[0];
            String alertedUser = strArr[1];

            // currentUser에 대응하는 Set 가져오기. 없으면 새로운 HashSet 생성.
            Set<String> alertSet = usersAlertSet.getOrDefault(currentUser, new HashSet<>());

            // alertSet에 alertedUser 추가.
            alertSet.add(alertedUser);

            // usersAlertSet 업데이트.
            usersAlertSet.put(currentUser, alertSet);
        }

        // 신고 대상자에 대해 신고횟수 count
        for(String userName : id_list) {
            Set<String> alertSet = usersAlertSet.getOrDefault(userName, new HashSet<>());

            for(String alertedUserName : alertSet){
                alertCountOfUser.put(alertedUserName ,alertCountOfUser.getOrDefault(alertedUserName , 0) + 1);
            }
        }

        // id_list를 순회하며 해당 사용자에게 신고 결과 횟수 리스트로 변환하기
        int[] answer = new int[id_list.length];
        for(int i=0;i<id_list.length;i++) {
            String user=id_list[i];
            Set<String> alerts=usersAlertSet.getOrDefault(user,new HashSet<>());
            for(String reported:alerts) {
                if(alertCountOfUser.get(reported)>=k)
                    answer[i]++;
            }
        }


        return answer;
    }
}