import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        for (int i = 0; i < 6; i++) {
            total += arr[i];
        }  

        int res = total;
        for (int i = 0; i < 6; i++) {
            for (int j = i+1; j < 6; j++) {
                for (int k = j+1; k < 6; k++) {
                    int tmp = 0;

                    tmp += (arr[i] + arr[j] + arr[k]);

                    res = Math.min(res, Math.abs(total - tmp - tmp));
                }
            }
        }

        System.out.println(res);


    }
}