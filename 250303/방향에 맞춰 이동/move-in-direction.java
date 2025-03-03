import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    static int N;
    static int x, y;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        x = 0;
        y = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String d = st.nextToken();
            int v = Integer.parseInt(st.nextToken());

            if (d.equals("N")) {
                x += dx[3] * v;
                y += dy[3] * v;
            } else if (d.equals("S")) {
                x += dx[2] * v;
                y += dy[2] * v;
            } else if (d.equals("E")) {
                x += dx[1] * v;
                y += dy[1] * v;
            } else {
                x += dx[0] * v;
                y += dy[0] * v;
            }
        }

        System.out.println(x + " " + y);
    }
}