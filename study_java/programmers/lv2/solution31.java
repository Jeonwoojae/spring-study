import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;  // 가능한 스킬트리 갯수

        // 시도할 스킬트리들 검증
        for (String skillTree : skill_trees) {
            if (isPracticable(skill, skillTree)) {
                // 배울 수 있는 스킬트리면 answer++
                answer++;
            }
        }

        return answer;
    }

    // skill : 선행 스킬트리, skillTree : 시도할 스킬트리
    private boolean isPracticable(String skill, String skillTree) {
        int learningIndex = 0;

        // String.toCharArray() : 해당 string을 char 배열로 바꾸는 함수
        for (char c : skillTree.toCharArray()) {
            // String.indexOf(Char) : char에 해당하는 글자가 String의 어느 위치에 있는지 반환하는 함수
            int index = skill.indexOf(c);

            if (index == -1) {  // 스킬트리에 없는 스킬은 무시
                continue;
            } else if (index == learningIndex) {  // 해당 스킬을 배울 차례
                learningIndex++;
            } else {  // 선행 스킬이 배워지지 않았음
                return false;
            }
        }

        return true;
    }
}
