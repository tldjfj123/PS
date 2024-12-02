import java.util.*;

class Solution {
    public boolean solution(int x) {
        int c = calc(x);
        
        if (x % c == 0) {
            return true;
        }
        
        return false;
    }
    
    static int calc(int n) {
        String s = String.valueOf(n);
        
        char[] arr = s.toCharArray();
        
        int res = 0;
        
        for (char a : arr) {
            res += a - '0';
        }
        
        return res;
    }
}