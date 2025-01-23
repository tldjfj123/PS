import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new int[] {a, b};
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    boolean[] board = new boolean[101];

                    boolean flag = true;
                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }

                        for (int m = arr[l][0]; m <= arr[l][1]; m++) {
                            if (!board[m]) {
                                board[m] = true;
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }

                    if (flag) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}