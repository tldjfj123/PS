import java.util.*;
import java.io.*;

public class Main {
    static int a1, b1, c1, a2, b2, c2, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        b1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a2 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        int cnt = 0;

        // 모든 조합 (순열) 탐색
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    // 첫 번째 조합과 2 이내 거리인지 확인
                    boolean firstUnlock = inRange(a1, i) && inRange(b1, j) && inRange(c1, k);
                    // 두 번째 조합과 2 이내 거리인지 확인
                    boolean secondUnlock = inRange(a2, i) && inRange(b2, j) && inRange(c2, k);

                    if (firstUnlock || secondUnlock) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    // 거리 계산 (원형 구조 반영)
    static boolean inRange(int a, int b) {
        int range1 = Math.abs(a - b);
        int range2 = n - range1; // 원형이므로 반대편 거리 계산

        return Math.min(range1, range2) <= 2;
    }
}
