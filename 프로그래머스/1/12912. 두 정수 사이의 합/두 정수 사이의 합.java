class Solution {
    public long solution(int a, int b) {
        long res = 0;
        
        if (a < b) {
            for (int i = a; i <= b; i++) {
                res += (long)i;
            }    
        } else {
            for (int i = b; i <= a; i++) {
                res += (long)i;
            }
        }
        
        
        
        return res;
    }
}