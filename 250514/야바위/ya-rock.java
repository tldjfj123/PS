import java.util.*;
import java.io.*;

public class Main {
    static int n, a, b, c;
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i] = new int[] {a, b, c};
        }

        // 위치를 전부 탐색하여 값 구하기
        int res = 0;
        for (int i = 0; i < 3; i++) { // 돌의 위치
            int std = i;

            int cnt = 0;

            //컵에 돌 집어넣기
            int[] tmp = new int[3];
            tmp[i] = 1;

            for (int j = 0; j < n; j++) {
                int start = arr[j][0]-1;
                int end = arr[j][1]-1;
                int open = arr[j][2]-1;

                int v = tmp[start];
                tmp[start] = tmp[end];
                tmp[end] = v;

                if (tmp[open] == 1) {
                    cnt++;
                }
                
            }

            res = Math.max(cnt, res);
        }

        System.out.println(res);
    }
}