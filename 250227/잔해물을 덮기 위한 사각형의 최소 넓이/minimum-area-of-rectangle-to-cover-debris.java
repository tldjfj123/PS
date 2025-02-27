import java.util.*;
import java.io.*;

public class Main {
    static int x1, y1, x2, y2;
    static int a1, b1, a2, b2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 번째 직사각형 입력
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        // 두 번째 직사각형 입력
        st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        b1 = Integer.parseInt(st.nextToken());
        a2 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());

        // 겹치는 영역 계산
        int overlapX1 = Math.max(x1, a1);
        int overlapY1 = Math.max(y1, b1);
        int overlapX2 = Math.min(x2, a2);
        int overlapY2 = Math.min(y2, b2);

        // 완전히 덮이면 0 반환
        if (overlapX1 >= overlapX2 || overlapY1 >= overlapY2) {
            System.out.println(0);
            return;
        }

        // 남아있는 부분을 감싸는 최소 직사각형 계산
        int minX = Math.min(x1, overlapX1);
        int minY = Math.min(y1, overlapY1);
        int maxX = Math.max(x2, overlapX2);
        int maxY = Math.max(y2, overlapY2);

        int minCoverWidth = maxX - minX;
        int minCoverHeight = maxY - minY;
        int minCoverArea = minCoverWidth * minCoverHeight;

        System.out.println(minCoverArea);
    }
}
