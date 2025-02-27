import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        arr = new int[2001];  // 인덱스: 0~2000 사용
        int idx = 1000;  // 시작 위치 (0을 1000으로 변환)

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());  // 이동 거리
            String o = st.nextToken();  // 방향 (L or R)

            for (int j = 0; j < v; j++) {
                if (o.equals("L")) {
                    arr[idx - 1]++;  // 왼쪽으로 이동하는 경우, 이전 구간을 증가
                    idx--;
                } else {
                    arr[idx]++;  // 오른쪽으로 이동하는 경우, 현재 구간을 증가
                    idx++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 2001; i++) {
            if (arr[i] >= 2) {  // 구간이 2번 이상 지나갔는지 확인
                res++;
            }
        }

        System.out.println(res);
    }
}
