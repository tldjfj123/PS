import java.util.*;

class Solution {
    public int solution(int num) {
        
        int cnt = 0;
        long n = num;
        
        while (cnt != 500) {
            if (n == 1) {
                break;
            }
            
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n * 3) + 1;
            }
            
            cnt++;
            
            
        }
        
        
        if (cnt == 500 && n != 1) {
            return -1;
        }
        
        return cnt;

    }
}