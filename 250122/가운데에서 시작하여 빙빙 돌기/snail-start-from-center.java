import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        int startX = n-1;
        int startY = n;
        int idx = 0;

        int cnt = n * n;
        while (cnt > 0) {
            int nx = startX + dx[idx];
            int ny = startY + dy[idx];

            if (inRange(nx, ny) && arr[nx][ny] == 0) {
                arr[nx][ny] = cnt;
                startX = nx;
                startY = ny;
                cnt--;

            } else {
                if (idx == 3) {
                    idx = 0;
                } else {
                    idx++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    // 범위 내 확인 함수
    static boolean inRange(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < n) {
            return true;
        }

        return false;
    }
}