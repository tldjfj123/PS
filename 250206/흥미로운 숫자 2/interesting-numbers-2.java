import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = x; i <= y; i++) {
            if (isInterestingNumber(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isInterestingNumber(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        Map<Integer, Integer> map = new HashMap<>();

        // 0부터 9까지 센 갯수 값을 Map에 저장
        for (int i = 0; i < 10; i++) {
            for (char c : arr) {
                if (c - '0' == i) {
                    if (!map.containsKey(i)) {
                        map.put(i, 1);
                    } else {
                        int tmp = map.get(i) + 1;
                        map.put(i, tmp);
                    }
                }
            }
        }

        if (map.size() == 2) {
            List<Integer> tmp = new ArrayList<>(map.values());
            if (tmp.contains(1)) {
                return true;
            }
            
        }
        return false;
    }
}