class Solution {
    public String solution(int n) {
        String res = "";
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res += "수";
            } else {
                res += "박";
            }
        }
        
        
        return res;
    }
}