import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        char[] arr = s.toCharArray();

        // 시작은 북쪽        

        int idx = 0;
        int x = 0;
        int y = 0;

        int res = -1;
        int cnt = 0;

        for (char a : arr) {
            cnt++;
            if (a == 'F') {
                x += dx[idx];
                y += dy[idx];
                if (x == 0 && y == 0) {
                    res = cnt;
                    break;
                }
            } else if (a == 'R') {
                if (idx == 3) {
                    idx = 0;
                } else {
                    idx++;
                }
            } else {
                if (idx == 0) {
                    idx = 3;
                } else {
                    idx--;
                }
            }
        }

        System.out.println(res);

    }
}