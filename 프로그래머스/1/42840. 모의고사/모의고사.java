import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 1번 : 12345
        // 2번 : 21232425
        // 3번 : 3311224455
        
        // 1. 문제와 정답 매칭시키기
        int first = 0;
        int[] answer1 = new int[] {1, 2, 3, 4, 5};
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == answer1[i % answer1.length]) {
                first++;
            }
        }
        
        int second = 0;
        int[] answer2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        for (int i = 0; i < answers.length; i++) {            
            if (answers[i] == answer2[i % answer2.length]) {
                second++;
            }
        }
        
        int third = 0;
        int[] answer3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < answers.length; i++) {            
            if (answers[i] == answer3[i % answer3.length]) {
                third++;
            }
        }
        
        // 2. 제일 많이 맞춘사람 찾기
        int maxValue = Math.max(first, Math.max(second, third));
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (maxValue == first) {
            res.add(1);
        }
        
        if (maxValue == second) {
            res.add(2);
        }
        
        if (maxValue == third) {
            res.add(3);
        }
        
        Collections.sort(res);
        
        int[] resArr = res.stream().mapToInt(Integer::intValue).toArray();
        
        return resArr;
    }
}