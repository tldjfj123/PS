import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();

        // 주가를 순회하며 하락 지점을 계산
        for (int i = 0; i < n; i++) {
            // 스택에 저장된 인덱스의 가격이 현재 가격보다 크면 하락 발생
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                arr[idx] = i - idx; // 하락 발생 시점 계산
            }
            stack.push(i); // 현재 인덱스를 스택에 추가
        }

        // 스택에 남아 있는 인덱스는 끝까지 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            arr[idx] = n - 1 - idx; // 끝까지 유지된 시간 계산
        }

        return arr;
    }
}
