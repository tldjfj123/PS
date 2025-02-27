import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        arr = new int[2001];
        int idx = 1000;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            String o = st.nextToken();

            // arr[idx]++; // 출발점 +1 
            
            if (o.equals("L")) {
                for (int j = 0; j < v; j++) {
                    idx--;
                    arr[idx]++;
                }
            } else {
                for (int j = 0; j < v; j++) {
                    idx++;
                    arr[idx]++;
                }
            }
        }       

        int res = 0;
        for (int i = 0; i < 2001; i++) {
            if (arr[i] >= 2) {
                // System.out.println(i);
                res++;
            }
        }

        System.out.println(res);
    }
}