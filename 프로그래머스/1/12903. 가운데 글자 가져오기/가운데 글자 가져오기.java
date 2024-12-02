import java.util.*;

class Solution {
    public String solution(String s) {
        String res = "";
        
        if (s.length() % 2 == 0) {
            int evenIdx = s.length() / 2 - 1;
            
            for (int i = evenIdx; i < evenIdx + 2; i++) {
                res += String.valueOf(s.charAt(i));
            }
            
        } else {
            int oddIdx = s.length() / 2;
            
            res += String.valueOf(s.charAt(oddIdx));
        }
        
        return res;
    }
}