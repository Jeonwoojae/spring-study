class Solution {
    public int solution(int n) {
        int minValue = 1;
        for(;minValue<n+1;minValue++){
            if(n%minValue==1) return minValue;
        }

        return minValue;
    }
}