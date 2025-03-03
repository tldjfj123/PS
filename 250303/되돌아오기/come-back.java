import java.util.*;
import java.io.*;

public class Main {
    static int n, x, y, cnt, res;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 주어진 방향에 맞게 좌표 값 변경
            //좌표가 0,0 으로 돌아올 시, 출력 후 종료

        n = Integer.parseInt(st.nextToken());

        x = 0;
        y = 0;

        cnt = 0;
        res = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String d = st.nextToken();
            int v = Integer.parseInt(st.nextToken());

            //{-1, 1, 0, 0}
            //{0, 0, -1, 1}

            if (d.equals("N")) {
                for (int j = 0; j < v; j++) {
                    x += dx[1];
                    y += dy[1];

                    cnt++;

                    if (x == 0 && y == 0) {
                        res = cnt;
                        break;
                    }
                }
            } else if (d.equals("E")) {
                for (int j = 0; j < v; j++) {
                    x += dx[3];
                    y += dy[3];

                    cnt++;

                    if (x == 0 && y == 0) {
                        res = cnt;
                        break;
                    }
                }
            } else if (d.equals("W")) {
                for (int j = 0; j < v; j++) {
                    x += dx[2];
                    y += dy[2];

                    cnt++;

                    if (x == 0 && y == 0) {
                        res = cnt;
                        break;
                    }
                }
            } else { // S
                for (int j = 0; j < v; j++) {
                    x += dx[0];
                    y += dy[0];

                    cnt++;

                    if (x == 0 && y == 0) {
                        res = cnt;
                        break;
                    }
                }
            }

            if (x == 0 && y == 0) {
                break;
            }
        }

        System.out.println(res);


    }
}