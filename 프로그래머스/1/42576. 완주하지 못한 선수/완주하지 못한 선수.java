import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // HashMap에 참석자들 정보 담기
        Map<String, Integer> map = new HashMap<String, Integer>();
        String res = "";
        
        // 동명이인 처리
        for (String p : participant) {
            if (map.containsKey(p)) {
                map.put(p, map.get(p) + 1);
            } else {
                map.put(p, 1);
            }
        }
        
        // 완주자들 확인 처리
        for (String c : completion) {
            if (map.containsKey(c)) { 
                map.put(c, map.get(c) - 1);
            }
        }
        
        // map의 키값들로 값을 조회하면서 value가 0이 아닌 것 return (완주 못한 놈)
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                res = key;
                break;
            }
        }
        return res;
    }
}