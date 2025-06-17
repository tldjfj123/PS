import java.util.*;

class Report {
    List<String> list;
    int cnt;
    
    public Report (List<String> list, int cnt) {
        this.list = list;
        this.cnt = cnt;
    }
    
    @Override
    public String toString() {
        return "list : " + list + " cnt : " + cnt;
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Report> map = new HashMap<String, Report>();
        
        
        for (String r : report) {
            String[] tmp = r.split(" ");
            
            String reporter = tmp[0];
            String reported = tmp[1];
            
            if (!map.containsKey(reported)) { // 처음 신고당함
                List<String> list = new ArrayList<String>();
                list.add(reporter);
                
                map.put(reported, new Report(list, 1));
            } else {
                List<String> list = map.get(reported).list;
                // 중복신고인지 확인
                
                if (!list.contains(reporter)) {
                    list.add(reporter);
                    int cnt = map.get(reported).cnt + 1;
                    
                    map.put(reported, new Report(list, cnt));
                }
            }
        }
        
        // System.out.println(map);
        
        Map<String, Integer> res = new HashMap<String, Integer>();
        
        for (String id : id_list) {
            if (map.containsKey(id)) {
                if (map.get(id).cnt >= k) { // 기준 이상이면 결과 맵에 횟수
                    for (String s : map.get(id).list) {
                        if (!res.containsKey(s)) {
                            res.put(s, 1);
                        } else {
                            res.put(s, res.get(s) + 1);
                        }
                    }
                    
                    
                }
            }
        }
        
        // System.out.println(res);
        
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            if (res.containsKey(id_list[i])) {
                answer[i] = res.get(id_list[i]);
            }
        }
        return answer;
    }
}