import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        arr = new int[201];

        for (int i = 0; i < n; i++) {       
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) + 100;
            int b = Integer.parseInt(st.nextToken()) + 100;

            for (int j = a; j < b; j++) {
                arr[j]++;
            }
        }

        int res = 0;

        for (int i = 0; i < 200; i++) {
            res = Math.max(res, arr[i]);
        }

        System.out.println(res);
        




    }
}