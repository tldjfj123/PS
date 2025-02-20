import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new int[] {x, y};
        }

        // 첫 항 사이값들 모두 비교하면서 적합한지 확인
        for (int i = arr[0][0]; i <= arr[0][1]; i++) {
            boolean isOk = true;
            int v = i;

            for (int j = 0; j < n; j++) {
                v *= 2;
                int left = arr[j][0];
                int right = arr[j][1];

                if (left <= v && v <= right) {
                    continue;
                }

                isOk = false;
                break;
            }



            if (isOk) {
                System.out.println(i);
                break;
            }
        }

    }
}