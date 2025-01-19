import java.util.*;

class Solution {
    static int cnt1, cnt2;
    
    public int[] solution(String s) {
        cnt1 = 0; // 이진 변환 횟수
        cnt2 = 0; // 이진 변환 과정에서 제거된 모든 0의 갯수
        
        // s가 1이 될 때 까지 while 문
            // 1. 모든 문자 내 0 제거
            // 2. 제거한 문자의 길이를 c라고 하면, c를 2진법으로 표현
        
        while (!s.equals("1")) {
            char[] arr = s.toCharArray();
            
            String tmp = "";
            
            for (char a : arr) {
                if (a != '0') {
                    tmp += a;
                } else {
                    cnt2++;
                }
            }
            
            cnt1++;
            
            s = Integer.toBinaryString(tmp.length());
        }
        
        
        return new int[] {cnt1, cnt2};
    }
}