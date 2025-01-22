import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static char[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        int startX = 0;
        int startY = -1;
        int idx = 0;

        int cnt = 1;
        int ascii = 65;
        while (cnt != n * m + 1) {
            int nx = startX + dx[idx];
            int ny = startY + dy[idx];

            if (inRange(nx, ny) && arr[nx][ny] == 0) {
                arr[nx][ny] = (char)ascii;
                startX = nx;
                startY = ny;
                cnt++;
                
                if (ascii == 90) {
                    ascii = 65;
                } else {
                    ascii++;
                }

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