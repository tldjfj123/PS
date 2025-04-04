import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Integer> players = new ArrayList<>();
        for (int stage : stages) {
            players.add(stage);
        }

        Map<Integer, Double> failureRates = new HashMap<>();
        
        for (int stage = 1; stage <= N; stage++) {
            int reached = players.size();
            if (reached == 0) {
                failureRates.put(stage, 0.0);
                continue;
            }

            int failed = 0;
            // 명시적 반복문으로 실패한 플레이어 수 계산 및 제거
            Iterator<Integer> iterator = players.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == stage) {
                    failed++;
                    iterator.remove(); // 값을 제거
                }
            }

            double rate = (double) failed / reached;
            failureRates.put(stage, rate);
        }

        // 스테이지 번호를 리스트에 추가
        List<Integer> sortedStages = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            sortedStages.add(i);
        }

        // 실패율 기준으로 정렬
        Collections.sort(sortedStages, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                double rateA = failureRates.get(a);
                double rateB = failureRates.get(b);
                if (rateA != rateB) {
                    return Double.compare(rateB, rateA); // 실패율 내림차순
                }
                return a - b; // 실패율 같으면 스테이지 번호 오름차순
            }
        });

        // 결과를 배열로 변환하여 반환
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = sortedStages.get(i);
        }

        return result;
    }
}
