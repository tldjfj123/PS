import java.util.*;
import java.io.*;

public class Main {
    static String[] arr;
    static int T, a, b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arr = new String[1001];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            String v = st.nextToken();
            int idx = Integer.parseInt(st.nextToken());

            arr[idx] = v;
            
        }

        int cnt = 0;

        // 기준이 되는 index를 정해주는 for 문
        for (int i = a; i <= b; i++) {
            // 1, 1000 까지 모든 범위를 탐색하여 S, N의 최기 idx 값을 갱신함
            int d1 = 1001;
            int d2 = 1001;

            for (int j = 1; j <= 1000; j++) {
                if (arr[j] != null) {
                    if (arr[j].equals("S")) {
                        d1 = Math.min(d1, Math.abs(i - j));
                    } else if (arr[j].equals("N")) {
                        d2 = Math.min(d2, Math.abs(i - j));
                    }
                }
                
            }

        

            if (d1 <= d2) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}