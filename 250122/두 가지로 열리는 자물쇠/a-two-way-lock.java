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

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (checkCondition1(i, j, k) || checkCondition2(i, j, k)) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean checkCondition1(int a, int b, int c) {
        return check(a1, a) && check(b1, b) && check(c1, c);
    }

    static boolean checkCondition2(int a, int b, int c) {
        return check(a2, a) && check(b2, b) && check(c2, c);
    }

    static boolean check(int x, int y) {
        int directDist = Math.abs(x - y);
        int wrapDist = n - directDist;  // ✅ 원형 거리 올바르게 계산
        return Math.min(directDist, wrapDist) <= 2;
    }
}
