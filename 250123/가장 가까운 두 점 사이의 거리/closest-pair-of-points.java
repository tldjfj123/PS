import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new int[] {x, y};
        }

        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                res = Math.min(res, getDistanceSquare(arr[i][0], arr[i][1], arr[j][0], arr[j][1]));
            }
        }

        System.out.println(res);

        
    }

    static int getDistanceSquare(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}