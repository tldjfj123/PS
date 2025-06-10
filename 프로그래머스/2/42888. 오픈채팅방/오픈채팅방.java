import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 명령어 Enter / Leave / Change
        
        // uid : nickname 쌍을 갖는 해시 맵 생성
        Map<String, String> map = new HashMap<String, String>();
        
        List<String> res = new ArrayList<String>();
        
        for (String r : record) {
            String[] tmp = r.split(" ");            
            String order = tmp[0];
            
            if (order.equals("Enter")) {
                String uid = tmp[1];
                String nickname = tmp[2];
                
                map.put(uid, nickname);
            } else if (order.equals("Change")) {
                String uid = tmp[1];
                String nickname = tmp[2];
                
                map.put(uid, nickname);

            }
        }
        
        for (int i = 0; i < record.length; i++) {
            String[] tmp2 = record[i].split(" ");
            
            String o = tmp2[0];
            String u = tmp2[1];
            
            if (o.equals("Enter")) {
                res.add(map.get(u) + "님이 들어왔습니다.");
            } else if (o.equals("Leave")) {
                res.add(map.get(u) + "님이 나갔습니다.");
            }
        }
        // System.out.println(res);
        
        String[] answer = new String[res.size()];        
        
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        return answer;
    }
}