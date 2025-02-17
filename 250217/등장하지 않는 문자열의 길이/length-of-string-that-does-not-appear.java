import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static String s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();

        // 연속부분문자열로 두 번 이상 나타나지 않는 문자열의 최소 길이를 출력
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) { // 출발점
            for (int j = i+1; j <= n; j++) { // 끝점
                String w = s.substring(i, j); // 모든 부분문자열 생성
                boolean isOk = true;

                for (int k = 1; k <= n-(w.length()); k++) {
                    if (s.substring(k, (k + w.length())).equals(w)) {
                        isOk = false;
                        break;
                    }
                }

                if (isOk) {
                    res = Math.min(w.length(), res);
                }
            }
        }

        System.out.println(res);

    }
}