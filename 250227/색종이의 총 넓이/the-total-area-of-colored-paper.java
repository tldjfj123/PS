import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[200][200];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) + 100;
            int b = Integer.parseInt(st.nextToken()) + 100;

            for (int j = a; j < a + 8; j++) {
                for (int k = b; k < b + 8; k++) {
                    if (arr[j][k] == 0) {
                        arr[j][k]++;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                if (arr[i][j] == 1) {
                    res++;
                }
            }
        }

        System.out.println(res);

    }

    
}