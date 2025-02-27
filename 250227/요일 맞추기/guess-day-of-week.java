import java.util.*;
import java.io.*;

public class Main {
    static int m1, m2, d1, d2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m1 = Integer.parseInt(st.nextToken());
        d1 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
        d2 = Integer.parseInt(st.nextToken());

        int[] days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int t1 = 0;
        for (int i = 0; i < m1; i++) {
            t1 += days[i];
        }

        t1 += d1;

        int t2 = 0;
        for (int i = 0; i < m2; i++) {
            t2 += days[i];
        }

        t2 += d2;

        String[] arr = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int gap = t2 - t1;

        if (gap < 0) {
            System.out.println(arr[((Math.abs(gap) % 7) * -1) + 7]);
        } else {
            System.out.println(arr[gap % 7]);
        }
    }
}