import java.util.*;
import java.io.*;

public class Main {
    static int OFFSET = 1000;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[2001][2001];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (i == 2) {
                int x1 = Integer.parseInt(st.nextToken()) + OFFSET;
                int y1 = Integer.parseInt(st.nextToken()) + OFFSET;
                int x2 = Integer.parseInt(st.nextToken()) + OFFSET;
                int y2 = Integer.parseInt(st.nextToken()) + OFFSET;

                for (int j = x1; j < x2; j++) {
                    for (int k = y1; k < y2; k++) {
                        if (arr[j][k] == 1) {
                            arr[j][k] = 0;
                        }
                    }
                }

            } else {
                int x1 = Integer.parseInt(st.nextToken()) + OFFSET;
                int y1 = Integer.parseInt(st.nextToken()) + OFFSET;
                int x2 = Integer.parseInt(st.nextToken()) + OFFSET;
                int y2 = Integer.parseInt(st.nextToken()) + OFFSET;

                for (int j = x1; j < x2; j++) {
                    for (int k = y1; k < y2; k++) {
                        if (arr[j][k] == 0) {
                            arr[j][k] = 1;
                        }
                    }
                }
            }
        }
        
        int res = 0;

        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if (arr[i][j] == 1) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}