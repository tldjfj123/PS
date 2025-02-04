import java.util.*;
import java.io.*;

public class Main {
    static int n, c, g, h;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[n][2];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            min = Math.min(start, min);
            max = Math.max(max, end);

            arr[i] = new int[]{start, end};
        }

        int res = 0;
        for (int i = min; i <= max; i++) { // 기준 온도
            int tmp = 0;

            for (int j = 0; j < n; j++) {
                tmp += getPerformance(arr[j][0], arr[j][1], i);
            }

            res = Math.max(res, tmp);
        }

        System.out.println(res);

        

        

    }

    static int getPerformance(int start, int end, int std) {
        if (std < start) {
            return c;
        } else if (std > end) {
            return h;
        } else {
            return g;
        }
    }
}