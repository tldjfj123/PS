import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        //전체 경우의 수 담을 배열 크기 구하기
        int resSize = ((numbers.length) * (numbers.length - 1)) / 2;
        
        // 배열 선언 및 2개 뽑아서 값 추가
        int[] res = new int[resSize];
        
        int idx =  0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                res[idx] = numbers[i] + numbers[j];
                idx++;
            }
        }
        
        // 중복 제거 (stream 활용)
        int[] tmp = Arrays.stream(res)
            .distinct()
            .toArray();
        
        Arrays.sort(tmp);
        
        return tmp;
    }
}