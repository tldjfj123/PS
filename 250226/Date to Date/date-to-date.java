import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int total1 = 0;
        for (int i = 0; i < m1 - 1; i++) {  
            total1 += days[i];
        }
        total1 += d1; 

        int total2 = 0;
        for (int i = 0; i < m2 - 1; i++) {  
            total2 += days[i];
        }
        total2 += d2; 

        System.out.println(total2 - total1 + 1);
    }
}
