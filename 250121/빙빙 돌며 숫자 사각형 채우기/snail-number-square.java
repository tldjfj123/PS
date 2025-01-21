import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int n, m, x, y, cnt, idx;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        
        // 빈 배열 선언 
        arr = new int[n][m];

        // 시작점 및 방향 인덱스 선언
        x = 0;
        y = -1;
        idx = 0;
        cnt = 1;
        
        //while문 돌면서 벽에 부딫히거나 값이 들어가 있는 칸 만나기 전 까지 우측으로 진행
        //부딫히면 우 > 하 > 좌 > 상 순으로 방향변경

        while (cnt != n * m + 1) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if (inRange(nx, ny) && arr[nx][ny] == 0) {
                arr[nx][ny] = cnt;
                x = nx;
                y = ny;
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

    // 범위 내에 있는지 확인하는 메소드
    static boolean inRange(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < m) {
            return true;
        }

        return false;
    }
}