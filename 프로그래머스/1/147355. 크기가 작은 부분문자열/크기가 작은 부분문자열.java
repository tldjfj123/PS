class Solution {
    public int solution(String t, String p) {
        int res = 0;
        long std = Long.valueOf(p);
        
        for (int i = 0; i <= t.length() - p.length(); i++) {
            Long tmp = Long.valueOf(t.substring(i, i + p.length()));
            
            if (std >= tmp) {
                res++;
            }
        }
        
        
        return res;
    }
}