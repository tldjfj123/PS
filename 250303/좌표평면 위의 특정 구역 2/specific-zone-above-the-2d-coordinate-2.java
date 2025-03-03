import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        
        arr = new int[n][2];
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new int[] {x, y};
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, makeSquare(i, arr));
        }

        System.out.println(res);
    }

    // 사각형 넓이 연산해주는 메소드
    static int makeSquare(int passIdx, int[][] arr) {
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // 패스하기로한 좌표면 pass
            if (i == passIdx) {
                continue;
            }

            xMin = Math.min(xMin, arr[i][0]);
            yMin = Math.min(yMin, arr[i][1]);
            xMax = Math.max(xMax, arr[i][0]);
            yMax = Math.max(yMax, arr[i][1]);
        }

        return Math.abs(xMax - xMin) * Math.abs(yMax - yMin);
    }
    
}