import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int std = 10 * 1440 + 11 * 60 + 11;
        int calc = (a - 1) * 1440 + (b * 60) + c;
        
        // System.out.println(std + " " + calc);
        if (calc - std < 0) {
            System.out.println(-1);
        } else {
            System.out.println(calc - std);
        }

        
    }
}