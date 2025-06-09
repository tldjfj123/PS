import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        // map에 사람 추가하기
        for (String p : participant) {
            if (!map.containsKey(p)) {
                map.put(p, 1);
            } else {
                int tmp = map.get(p);
                map.put(p, tmp+1);
            }
        }
        
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // System.out.println(map);
        
        String res = "";
        for (String p : participant) {
            if (map.get(p) != 0) {
                res = p;
                break;
            }
        }
        
        return res;
    }
}