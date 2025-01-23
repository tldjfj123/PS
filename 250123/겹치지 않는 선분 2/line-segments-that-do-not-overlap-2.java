import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            arr[i] = new int[] {x1, 0, x2, 1};
        }

        //두 선분 골라서 교차 여부 확인
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(isCrossed(arr[i], arr[j])) {
                    check[i] = true;
                    check[j] = true;
                }
            }
        }   

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isCrossed(int[] p1, int[] p2) {
        int x1 = p1[0], y1 = p1[1];
        int x2 = p1[2], y2 = p1[3];
        int x3 = p2[0], y3 = p2[1];
        int x4 = p2[2], y4 = p2[3];
        
        int ccw1 = ccw(x1, y1, x2, y2, x3, y3);
        int ccw2 = ccw(x1, y1, x2, y2, x4, y4);
        int ccw3 = ccw(x3, y3, x4, y4, x1, y1);
        int ccw4 = ccw(x3, y3, x4, y4, x2, y2);
        
        if (ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0) {
            // Special case: check if lines are on the same line
            if (ccw1 == 0 && ccw2 == 0 && ccw3 == 0 && ccw4 == 0) {
                // Check if line segments overlap
                return Math.max(x1, x2) >= Math.min(x3, x4) && 
                    Math.max(x3, x4) >= Math.min(x1, x2);
            }
            return true;
        }
        return false;
    }

    static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Calculate cross product to determine orientation
        long result = (long)(x2 - x1) * (y3 - y1) - (long)(x3 - x1) * (y2 - y1);
        if (result > 0) return 1;
        if (result < 0) return -1;
        return 0;
    }
}