import java.util.*;

class Solution
{
    public int solution(String s){
        char[] arr = s.toCharArray();
        
        Stack<Character> stack = new Stack<Character>();
        
        for (char a : arr) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else {
                if (stack.peek() == a) {
                    stack.pop();
                } else {
                    stack.push(a);
                }
            }
        }
        
        // System.out.println(stack);

        if (stack.isEmpty()) {
            return 1;
        }
        
        return 0;
    }
}