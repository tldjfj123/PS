import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //n이하의 수
        m = Integer.parseInt(st.nextToken()); // 쌍 갯수

        arr = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new int[]{a, b};
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = 0;

                for (int k = 0; k < m; k++) {
                    if (isSame(i, j, arr[k][0], arr[k][1])) {
                        tmp++;
                    }
                }

                res = Math.max(tmp, res);
            }
        }

        System.out.println(res);




    }

    // 같은 쌍인지 판별하는 메소드
    static boolean isSame(int a, int b, int c, int d) {
        if ((a == c && b == d) || (a == d && b == c)) {
            return true;
        }

        return false;

    }


}