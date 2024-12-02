class Solution {
    public int solution(int left, int right) {
        int res = 0;
        
        for (int i = left; i <= right; i++) {
            if (calc(i) % 2 == 0) {
                res += i;
            } else {
                res -= i;
            }
        }
        
        return res;
    }
    
    
    static int calc(int n) {
        int cnt = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
            }
        }
        
        return cnt;
            
    }
}