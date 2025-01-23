import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken()); // 줄
        n = Integer.parseInt(st.nextToken()); // 깂 갯수

        arr = new int[k][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
            }

            arr[i] = tmp;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                
                boolean flag = true;
                for (int l = 0; l < k; l++) { // 경기 기록 지정
                    int head = 0;
                    int tail = 0;

                    // 앞선 사람 idx 찾기
                    for (int m = 0; m < n; m++) {
                        if (arr[l][m] == i) {
                            head = m;
                        }
                    }

                    // 뒤쳐진 사람 idx 찾기
                    for (int m = 0; m < n; m++) {
                        if (arr[l][m] == j) {
                            tail = m;
                        }
                    }

                    // 뒤 > 앞이면 flag false로 바꾸기
                    if (tail > head) {
                        flag = false;
                        break;
                    }
                
                }

                if (flag) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}