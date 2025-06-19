import java.util.*;

class Solution {
    private Map<String, Integer> freqMap = new HashMap<>();
    private List<String> result = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        // 주문 데이터 알파벳 순 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }
        
        // 코스 크기별 조합 생성 및 빈도 수 집계
        for (int k : course) {
            freqMap.clear();
            for (String order : orders) {
                if (order.length() < k) continue;
                generateCombinations(order, k, 0, new StringBuilder());
            }
            
            // 최대 빈도 조합 선정
            if (freqMap.isEmpty()) continue;
            int maxFreq = Collections.max(freqMap.values());
            if (maxFreq < 2) continue;
            
            for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
                if (entry.getValue() == maxFreq) {
                    result.add(entry.getKey());
                }
            }
        }
        
        // 결과 사전 순 정렬
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    
    private void generateCombinations(String order, int k, int start, StringBuilder current) {
        if (current.length() == k) {
            String comb = current.toString();
            freqMap.put(comb, freqMap.getOrDefault(comb, 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            current.append(order.charAt(i));
            generateCombinations(order, k, i + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
