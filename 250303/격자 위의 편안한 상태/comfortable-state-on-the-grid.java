import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        // m번 만큼 색칠 진행
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            arr[x][y] = 1;

            System.out.println(isComfortable(x, y));
        }
    }

    // 범위 확인 메소드
    static boolean inRange(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < n) {
            return true;
        }

        return false;
    }


    // 편안한 상태인지 확인하는 메소드
    static int isComfortable(int x, int y) {
        int cnt = 0;

        //4방향 확인
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inRange(nx, ny) && arr[nx][ny] == 1) {
                cnt++;
            }
        }

        if (cnt == 3) {
            return 1;
        }

        return 0;
    }

}