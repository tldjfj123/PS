import java.util.*;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        
        String[] arr = s.split("");
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        String res = "";
        
        for (String a : arr) {
            res += a;
        }
        
        return Long.valueOf(res);
    }
}