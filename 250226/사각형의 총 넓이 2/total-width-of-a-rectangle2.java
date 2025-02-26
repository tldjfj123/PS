import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[201][201];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 100;
            int y1 = Integer.parseInt(st.nextToken()) + 100;
            int x2 = Integer.parseInt(st.nextToken()) + 100;
            int y2 = Integer.parseInt(st.nextToken()) + 100;


            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    if (arr[j][k] == 0) {
                        arr[j][k]++;
                    }
                }
            }
        }

        int res = 0;

        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (arr[i][j] == 1) {
                    res++;
                }
            }
        }

        System.out.println(res);

        
    }
}