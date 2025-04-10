import java.util.*;

class Solution {
    static int n;
    static int[][] arr;
    
    public int solution(int[][] board, int[] moves) {
        int cnt = 0;
        arr = board;
        n = board.length;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int move : moves) {
            int p = pick(move);
            
            if (p == 0){
                continue;
            }
            
            if (stack.isEmpty()) {
                stack.push(p);
            } else {
                if (stack.peek() == p) {
                    cnt += 2;
                    stack.pop();
                } else {
                    stack.push(p);
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(arr));
        
        return cnt;
    }
    
    static int pick(int move) { // 위치 입력 시 행의 최상단값 return
        int v = 0;
        
        for (int i = 0; i < n; i++) { // 행
            if (arr[i][move-1] != 0) {
                v = arr[i][move-1];
                arr[i][move-1] = 0;
                break;
            }
        }
        
        return v;
    }
}