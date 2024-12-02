class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int res = 0;
        
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                res += absolutes[i];
            } else {
                res -= absolutes[i];
            }
        }
        
        return res;
    }
}