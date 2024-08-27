import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for (int s : scoville) {
            heap.offer(s);
        }
        
        int cnt = 0;
        boolean isOk = false;
        while (heap.size() != 1) {
            if (heap.peek() >= K) {
                return cnt;
            }
            int calc = heap.poll() + (heap.poll() * 2);
            
            heap.offer(calc);
            cnt++;
        }
        
        if (heap.peek() >= K) {
                return cnt;
        }
        
        return -1;
    }
}