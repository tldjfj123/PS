import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int res = 0;

        // 점 3개 고르고 최댓값 구하기
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (isValidTriangle(arr[i], arr[j], arr[k])) {
                        res = Math.max(res, getWidth(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }

        System.out.println(res);
    }

    static boolean isValidTriangle(int[] x, int[] y, int[] z) {
        // 중간점이 x 인 경우
        if (x[1] == y[1] && x[0] == z[0] || x[1] == z[1] && x[0] == y[0]) {
            return true;
        }

        // 중간점이 y인 경우
        if (y[1] == z[1] && y[0] == x[0] || y[1] == x[1] && y[0] == z[0]) {
            return true;
        }

        // 중간점이 z인 경우
        if (z[1] == x[1] && z[0] == y[0] || z[1] == y[1] && z[0] == x[0]) {
            return true; 
        }

        return false;
    }

    static int getWidth(int[] x, int[] y, int[] z) {
        return Math.abs((x[0]*y[1] + y[0]*z[1] + z[0]*x[1]) - (y[0]*x[0] + z[0]*y[1] + x[0]*z[1]));
    }
}
