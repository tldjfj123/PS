import java.util.*;
import java.io.*;

public class Main {
    static int n, t, r, c;
    static String d;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //시행 횟수
        n = Integer.parseInt(st.nextToken()); 

        // 시간
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 초기 좌표
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 방향
        d = st.nextToken();

        // t초 동안 연산 진행 
        for (int i = 0; i < t; i++) {
            // 방향에 따라 연산 진행
            // 벽에 부딫힐 경우 방향 바꿔주기
            if (d.equals("U")) {
                int nx = r + dx[0];
                int ny = c + dy[0];

                if (inRange(nx, ny)) {
                    r = nx;
                    c = ny;
                } else {
                    d = "D";
                }
            } else if (d.equals("D")) {
                int nx = r + dx[1];
                int ny = c + dy[1];

                if (inRange(nx, ny)) {
                    r = nx;
                    c = ny;
                } else {
                    d = "U";
                }

            } else if (d.equals("R")) {
                int nx = r + dx[3];
                int ny = c + dy[3];

                if (inRange(nx, ny)) {
                    r = nx;
                    c = ny;
                } else {
                    d = "L";
                }

            } else { // W방향
                int nx = r + dx[2];
                int ny = c + dy[2];

                if (inRange(nx, ny)) {
                    r = nx;
                    c = ny;
                } else {
                    d = "R";
                }

            }
            // System.out.println(r + " " + c);
        }

        System.out.println(r + " " + c);


    }

    // 범위 안에 있는지 확인하는 메소드
    static boolean inRange(int x, int y) {
        if (1 <= x && x <= n && 1 <= y && y <= n) {
            return true;
        }

        return false;
    }

}