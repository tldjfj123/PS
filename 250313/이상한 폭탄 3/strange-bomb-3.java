import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 하나씩 확인하기
        int res = 0;
        int value = 0;
        
        for (int i = 0; i < n; i++) { // 인덱스 고르기
            int[] range = getRange(i);
            int std = arr[i];
            int cnt = 0;

            for (int j = range[0]; j <= range[1]; j++) {
                if (arr[j] == std) {
                    cnt++;
                }
            }

            // System.out.println("i : " + i + " cnt : " + cnt);

            if (cnt > 1) { // 터졌다
                //폭탄 터진거 최댓값보다 크면 갱신
                if (cnt >= value) {
                    if (arr[i] >= res) {
                        value = cnt;
                        res = arr[i];
                    }
                }
                
            }
            
            // res = Math.max(calc(arr[i]), res);
        }

        System.out.println(res);
    }

    // static int calc(int idx) {
        
    // }

    static int[] getRange(int v) {
        int left = v - k;
        int right = v + k;

        // left가 0보다 작으면 0으로
        if (left < 0) {
            left = 0;
        }
        // right가 n보다 크면 n으로
        if (right >= n) {
            right = n-1;
        }

        return new int[] {left, right};
    }


}