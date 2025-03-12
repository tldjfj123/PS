import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1부터 n까지 가능한 첫 번째 숫자(i)를 정하고 순열을 구성할 수 있는지 확인
        for (int i = 1; i <= n; i++) {
            boolean[] isUsed = new boolean[n + 1]; // 중복 체크 배열 (1~n까지 관리)
            int[] sequence = new int[n]; // 순열을 저장할 배열
            boolean flag = true;

            sequence[0] = i; // 첫 번째 숫자를 고정
            isUsed[i] = true;

            // 두 번째 숫자부터 순열 생성
            for (int j = 1; j < n; j++) {
                int next = arr[j - 1] - sequence[j - 1];

                // 유효 범위(1~n) 벗어나거나 중복되는 경우 실패
                if (next < 1 || next > n || isUsed[next]) {
                    flag = false;
                    break;
                }

                sequence[j] = next;
                isUsed[next] = true;
            }

            if (flag) {
                for (int j = 0; j < n; j++) {
                    System.out.print(sequence[j] + " ");
                }
            }
        }
    }
}
