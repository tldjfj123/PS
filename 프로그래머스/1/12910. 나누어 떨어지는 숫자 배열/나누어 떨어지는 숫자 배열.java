import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> tmp = new ArrayList<Integer>();
        
        for (int a : arr) {
            if (a % divisor == 0) {
                tmp.add(a);
            }
        }
        
        if (tmp.size() == 0) {
            return new int[] {-1};
        } else {
            int[] res = new int[tmp.size()];
            
            Collections.sort(tmp);
            
            for (int i = 0; i < tmp.size(); i++) {
                res[i] = tmp.get(i);
            }
            
            return res;
        }
    }
}