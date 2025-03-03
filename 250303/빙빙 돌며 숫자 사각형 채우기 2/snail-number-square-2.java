import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        int startX = -1;
        int startY = 0;
        int idx = 0;

        int cnt = 1;
        while (cnt != n * m + 1) {
            int nx = startX + dx[idx];
            int ny = startY + dy[idx];

            if (inRange(nx, ny) && arr[nx][ny] == 0) {
                arr[nx][ny] = cnt;
                startX = nx;
                startY = ny;
                cnt++;

            } else {
                if (idx == 3) {
                    idx = 0;
                } else {
                    idx++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    // 범위 내 확인 함수
    static boolean inRange(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < m) {
            return true;
        }

        return false;
    }
}