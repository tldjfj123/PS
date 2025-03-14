import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) { // 높이 차이 정하기
            for (int j = i+1; j <= 100; j++) {
                if(j - i > 17) {
                    break;
                }
               

                int cost = 0;

                for (int k = 0; k < n; k++) { // 언덕 돌며 확인
                    if (i <= arr[k] && arr[k] <= j) {
                        continue;
                    }

                    int v = Math.min(Math.abs(arr[k] - i), Math.abs(arr[k] - j));
                    
                    cost += Math.pow(v, 2);
                }

                res = Math.min(cost, res);
                
                // System.out.println("i : " + i + " j : " + j + " cost : " + cost);
            }
        }

        System.out.println(res);
    }
}