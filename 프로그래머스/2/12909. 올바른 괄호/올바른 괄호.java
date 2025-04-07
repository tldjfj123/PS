import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        // 문자열 배열로 변환
        char[] arr = s.toCharArray();
        
        for (Character a : arr) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else {
                if (a == '(') {
                    stack.push(a);
                } else { // )
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(a);
                    }
                }
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        }
        
        return false;
    }
}