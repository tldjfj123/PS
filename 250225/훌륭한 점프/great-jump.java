import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int maxV = 0;
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            arr[i] = v;
            maxV = Math.max(v, maxV);
        }

        int res = 100;
        for (int i = Math.max(arr[0], arr[n-1]); i <= maxV; i++) {
            if (isPossible(i)) {
                // System.out.println(i);
                res = Math.min(res, i);
            }
        }

        System.out.println(res);

        
    }
    // 최댓값을 최소로
    static boolean isPossible(int v) {
        int[] tmp = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= v) {
                tmp[cnt++] = i;
            }
        }

        // System.out.println(Arrays.toString(tmp) + " " + cnt);

        for (int i = 1; i < cnt; i++) {
            int d = tmp[i] - tmp[i-1];
            if (d > k) {
                return false;
            }
        }

        return true;
    }

}