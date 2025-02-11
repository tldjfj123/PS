import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int aMax = c / a;
        int bMax = c / b;

        int res = 0;
        for (int i = 0; i <= aMax; i++) {
            for (int j = 0; j <= bMax; j++) {
                int v = a * i + b * j;
                if (v <= c) {
                    res = Math.max(res, v);
                }
            }
        }

        System.out.println(res);

    }
}