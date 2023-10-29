class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;

        for (String word : goal) {
            boolean found = false;
            while (index1 < cards1.length && cards1[index1].equals(word)) {
                found = true;
                index1++;
                break;
            }

            while (!found && index2 < cards2.length && cards2[index2].equals(word)) {
                found = true;
                index2++;
                break;
            }

            if (!found)
                return "No";
        }

        return "Yes";
    }
}