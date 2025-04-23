import java.util.*;

class Solution {    
    static Deque<Integer> deque, speed;
    static List<Integer> tmp;
    
    public int[] solution(int[] progresses, int[] speeds) {
        deque = new ArrayDeque<Integer>();
        speed = new ArrayDeque<Integer>();
        tmp = new ArrayList<Integer>();
        
        for (int p : progresses) {
            deque.addLast(p);
        }
        
        for (int s : speeds) {
            speed.addLast(s);
        }
        
        while (!deque.isEmpty()) {
            // 일 진행시키기 (각각 더해주기)
            for (int i = 0; i < speed.size(); i++) {
                int v1 = speed.pollFirst();
                int v2 = deque.pollFirst();
                
                deque.addLast(v1 + v2);
                speed.addLast(v1);
            }
            
            // 완성 된거 확인
            int cnt = 0;
            while (!deque.isEmpty() && deque.peekFirst() >= 100) {
                cnt++;
                deque.pollFirst();
                speed.pollFirst();
            }
            
            if (cnt != 0) {
                tmp.add(cnt);
            }
            
        }
        
        
        // list to array
        int[] res = new int[tmp.size()];
        
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        
        return res;
        
    }
    
     
    
}