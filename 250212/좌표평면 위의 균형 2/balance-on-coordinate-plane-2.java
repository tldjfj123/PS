import java.util.*;
import java.io.*;

public class Main {
    static int n, maxX, maxY;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        maxX = 0;
        maxY = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new int[] {x, y};
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }
        

        // x, y 범위 내에서 각각 x, y를 정하여 좌표평면을 그려봄
        int res = Integer.MAX_VALUE;
        for (int i = 2; i <= maxX; i += 2) {
            for (int j = 2; j <= maxY; j += 2) {
                res = Math.min(res, calc(i, j));
            }
        }
        
        System.out.println(res);
    }

    // 4분면을 만들어서, 가장 많은 점이 있는 곳의 값 return
    static int calc(int x, int y) {
        // 1사분면 : ++
        int first = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i][0] > x && arr[i][1] > y) {
                first++;
            }
        }

        // 2사분면 : -+
        int second = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i][0] < x && arr[i][1] > y) {
                second++;
            }
        }
        // 3사분면 : --
        int third = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i][0] < x && arr[i][1] < y) {
                third++;
            }
        }
        // 4사분면 : +-
        int fourth = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i][0] > x && arr[i][1] < y) {
                fourth++;
            }
        }

        
        return Math.max(first, Math.max(second, Math.max(third, fourth)));
    }
}