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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int gap = 0;
        for (int i = 2; i <= n; i++) {
            
            int[] tmp = new int[i];

            for (int j = 0; j < i; j++) {
                tmp[j] = arr[j];    
            }

            if (Math.abs(tmp[0] - tmp[i-1]) <= k) {
                gap = Math.max(i, gap);
            }
        }

        System.out.println(gap);
    }
}