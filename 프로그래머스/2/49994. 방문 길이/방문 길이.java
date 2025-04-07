import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> pathSet = new HashSet<>();
        int x = 5, y = 5; // 시작 좌표 (0,0)을 (5,5)로 매핑

        for (char dir : dirs.toCharArray()) {
            int nx = x, ny = y;
            switch (dir) {
                case 'U': ny--; break;
                case 'D': ny++; break;
                case 'L': nx--; break;
                case 'R': nx++; break;
            }

            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;

            // 경로 키 생성 (양방향 고려)
            String key = generateKey(x, y, nx, ny);
            if (!pathSet.contains(key)) {
                pathSet.add(key);
            }

            x = nx;
            y = ny;
        }

        return pathSet.size();
    }

    private String generateKey(int x1, int y1, int x2, int y2) {
        // 경로를 정렬하여 양방향을 하나의 키로 통일
        if (x1 == x2) {
            return y1 < y2 ? x1 + "," + y1 + "," + x2 + "," + y2 : x2 + "," + y2 + "," + x1 + "," + y1;
        } else {
            return x1 < x2 ? x1 + "," + y1 + "," + x2 + "," + y2 : x2 + "," + y2 + "," + x1 + "," + y1;
        }
    }
}
