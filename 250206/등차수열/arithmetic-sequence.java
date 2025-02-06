import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        // 숫자 1개인 경우 : 0
        if (arr.length == 1) {
            System.out.println(0);
        } else { // 아닌경우 : 숫자 2개 정해서 차이 / 2 == 0 인지 확인
            int res = 0;

            for (int k = 1; k <= 100; k++) { // 기준이 되는 k 
                int cnt = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = i+1; j < n; j++) {
                        if (Math.abs(arr[i] - k) == Math.abs(arr[j] - k)) {
                            cnt++;
                        }
                    }
                }

                res = Math.max(cnt, res);
            }

            System.out.println(res);
        }

    }
}