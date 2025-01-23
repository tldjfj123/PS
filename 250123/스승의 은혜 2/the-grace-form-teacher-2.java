import java.util.*;
import java.io.*;

public class Main {
    static int n, b;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //반값 쓸 선물을 for문 통해 완전 탐색 
        // 예산 초과하면 break 하고 결과 최신화

        int res = 0;

        for (int i = 0; i < n; i++) {
            int budget = b;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    budget -= arr[j] / 2;
                } else {
                    budget -= arr[j];
                }

                if (budget < 0) {
                    res = Math.max(res, j);
                }
            }
        }

        System.out.println(res);

    }
}