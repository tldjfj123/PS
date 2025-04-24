import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> c1 = new ArrayDeque<>();
        Deque<String> c2 = new ArrayDeque<>();
        Deque<String> g = new ArrayDeque<>();

        // 순서대로 넣기 (addLast)
        for (String card : cards1) {
            c1.addLast(card);
        }
        for (String card : cards2) {
            c2.addLast(card);
        }
        for (String element : goal) {
            g.addLast(element);
        }

        // goal의 단어를 순서대로 확인
        while (!g.isEmpty()) {
            String target = g.peekFirst();
            if (!c1.isEmpty() && c1.peekFirst().equals(target)) {
                c1.pollFirst();
                g.pollFirst();
            } else if (!c2.isEmpty() && c2.peekFirst().equals(target)) {
                c2.pollFirst();
                g.pollFirst();
            } else {
                break; // 둘 다 아니면 실패
            }
        }

        return g.isEmpty() ? "Yes" : "No";
    }
}
