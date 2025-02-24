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
        int max = 0;
        int min = 1001;

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            arr[i] = v;
            max = Math.max(max, v);
            min = Math.min(min, v);
        }
    
        int res = 0;

        for (int i = 0; i < n; i++) { //기준 수 고르기
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if (Math.abs(arr[i] - arr[j]) <= k) {
                    cnt++;
                }
            }

            // System.out.println(arr[i] + " " + cnt);

            res = Math.max(cnt, res);
        }

        System.out.println(res);



    }
}