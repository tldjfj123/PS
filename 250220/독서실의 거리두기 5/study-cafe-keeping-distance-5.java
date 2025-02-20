import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static String[] arr;
    static String s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();

        int res = 0;
        // 들어갈 자리 골라서 앉히기
        for (int i = 0; i < n; i++) {
            arr = s.split("");
            // 앉아있으면 pass
            if (arr[i].equals("1")) {
                continue;
            }
            arr[i] = "1";
            // System.out.println(Arrays.toString(arr));

            res = Math.max(res, calc(arr));
        }

        System.out.println(res);
    }

    //사람 간 거리의 최댓값 구하는 메소드
    static int calc(String[] arr) {
        int idx = -1;
        int res = n;

        for (int i = 0; i < n; i++) {
            if (arr[i].equals("1")) {
                if (idx == -1) {
                    idx = i;
                } else {
                    // System.out.println(i - idx);
                    res = Math.min(res, i - idx);
                    idx = i;
                }
            }
        }

        // if (arr[n-1].equals("1")) {
        //     res = Math.min(res, n-1 - idx);
        // }

        return res;
    }
}