import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = -1;
        for (int i = 0; i < n-1; i++) { // 출발지점
            if (i + k >= n) {
                for (int j = i+1; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        res = Math.max(res, arr[j]);
                    }
                }
            } else {
                for (int j = i+1; j <= i + k; j++) {
                    if (arr[i] == arr[j]) {
                        res = Math.max(res, arr[j]);
                    }
                }
            }
        }

        System.out.println(res);
    }      
}