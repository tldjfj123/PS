import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int res = Integer.MAX_VALUE;
        //하나의 숫자 선택 하여 2배 하기
        for (int i = 0; i < n; i++) {
            int[] tmp = Arrays.copyOf(arr, arr.length);

            tmp[i] *= 2;

            for (int j = 0; j < n; j++) { // 하나 뺄 수 정하기
                //계산할 배열 만들기
                int[] calcArr = new int[n-1]; 
                int idx = 0;
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }

                    calcArr[idx] = tmp[k];
                    idx++;
                }

                // System.out.println(Arrays.toString(calcArr));

                int v = 0;
                for (int k = 0; k < calcArr.length-1; k++) {
                    v += Math.abs(calcArr[k] - calcArr[k+1]);
                }

                res = Math.min(res, v);
            }
        }

        System.out.println(res);
    }
}