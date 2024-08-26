import java.util.*;

class Solution {
    public int count(int n) {
        String binary = Integer.toBinaryString(n);
        char[] arr = binary.toCharArray();
        
        int cnt = 0;
        for (char a : arr) {
            if (a == '1') {
                cnt++;
            }
        }
        
        
        return cnt;
    }
    
    public int solution(int n) {
        int std = count(n);
        int res = 0;
        
        for (int i = n+1; i <= 1_000_000; i++) {
            if (count(i) == std) {
                res = i;
                break;
            }
        }
        
        return res;
    }
}