import java.util.*;

class Solution {
    public String solution(String phone_number) {
        String res = "";
        
        String[] arr = phone_number.split("");
        
        int length = arr.length - 4;
        
        for (int i = 0; i < arr.length - 4; i++) {
            res += "*";
        }
        
        for (int i = arr.length - 4; i < arr.length; i++) {
            res += arr[i];
        }
        
        return res;
    }
}