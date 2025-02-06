import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            max = Math.max(max, v);
            arr[i] = v;
        }

        int res = 0;
        for (int i = 1; i <= max; i++) { //기준 해수면 높이     
            //배열 돌면서 덩어리 세기
            int cnt = 0;

            List<Integer> tmp = new ArrayList<Integer>();

            for (int j = 0; j < n; j++) {
                if (arr[j] > i) {
                    tmp.add(arr[j]);
                } else {
                    if (!tmp.isEmpty()) {
                        tmp.clear();
                        cnt++;
                    }
                }
            }

            if (!tmp.isEmpty()) {
                cnt++;
            }

            res = Math.max(cnt, res);
        }

        System.out.println(res);


    }
}