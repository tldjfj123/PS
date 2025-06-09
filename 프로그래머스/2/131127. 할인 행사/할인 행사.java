import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // discount 배열을 돌면서 구매하려는 갯수 만큼의 할인 품목 갯수를 센 후, 정답 map과 일치하는지 비교
        
        // 정답map 만들기
        Map<String, Integer> std = new HashMap<String, Integer>();
        int idx = 0;
        for (String w : want) {
            std.put(w, number[idx]);
            idx++;
        }
        
        int res = 0;
        
        // 비교할 map 만들기
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            
            for (int j = i; j < i + 10; j++) {
                String item = discount[j];
                
                if (!map.containsKey(item)) {
                    map.put(item, 1);
                } else {
                    map.put(item, map.get(item) + 1);
                }
            }
            
            // 둘이 비교하기
            boolean flag = true;
            for (String w : want) {
                if (!map.containsKey(w) || map.get(w) != std.get(w)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                res++;
            }
        }
        
        return res;
    }
}