import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int n;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 칸을 돌면서 인접한 칸 확인 & 1의 갯수 3 이상이면 cnt에 ++
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (countOne(i, j) >= 3) {
                    cnt++;
                }
            }
        }

        // 결과 출력
        System.out.println(cnt);
    }

    // 유효한 범위인지 확인하는 함수
    static boolean inRange(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < n) {
            return true;
        }

        return false;
    }


    // 인접 칸 확인하는 함수
    static int countOne(int x, int y) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inRange(nx, ny) && arr[nx][ny] == 1) {
                cnt++;
            }
        }

        return cnt;
    }
}