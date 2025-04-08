import java.util.*;

class Solution {
    public int solution(String s) {
        
        int cnt = 0;
        Deque<Character> deque = init(s);
        for (int i = 0; i < s.length(); i++) { // 회전시킬 횟수
            // 회전 및 올바른 괄호인지 확인
            deque.offerLast(deque.pollFirst());
            // System.out.println(deque);
            if (isOk(new ArrayDeque(deque))) {
                cnt++;
            }
        }
        
        
        return cnt;
    }
    
    static Deque<Character> init(String s) {
        // 문자열 배열로 변환
        char[] arr = s.toCharArray();
        // 배열을 데크으로
        Deque<Character> deque = new ArrayDeque<Character>();
        
        for (char a : arr) {
            deque.offerLast(a);
        }
        
        return deque;
    }
    
    static boolean isOk(Deque<Character> deque) {
        Stack<Character> s = new Stack<Character>();
        
        while (!deque.isEmpty()) {
            char v = deque.pollFirst();
            
            if (s.isEmpty()) {
                s.push(v);
            } else {
                if (s.peek() == '(') {
                    if (v == ')') {
                        s.pop();
                    } else {
                        s.push(v);
                    }
                } else if (s.peek() == '{') {
                    if (v == '}') {
                        s.pop();
                    } else {
                        s.push(v);
                    }
                } else if (s.peek() == '[') {
                    if (v == ']') {
                        s.pop();
                    } else {
                        s.push(v);
                    }
                } else {
                    s.push(v);
                }
            }
        }
        
        if (s.isEmpty()) {
            return true;
        }
            
        return false;
    }
}