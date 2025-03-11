import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static String s;
    static String[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();

        arr = s.split("");

        // System.out.println(Arrays.toString(arr));

        // 모든 경우에 대해서 두명 앉히기
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                String[] tmp = Arrays.copyOf(arr, arr.length);

                // 해당 자리에 한사람이라도 앉아있으면 continue
                if (tmp[i].equals("1") || tmp[j].equals("1")) {
                    continue;
                }

                tmp[i] = "1";
                tmp[j] = "1";
                res = Math.max(getDistance(tmp), res);
            }
        }

        System.out.println(res);


    }

    // 사람간 거리의 최댓값을 구하는 메소드
    static int getDistance(String[] arr) {
        int idx = -1;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (idx == -1) {
                if (arr[i].equals("1")) {
                    idx = i;
                } 
            } else {
                if (arr[i].equals("1")) {
                    res = Math.min(res, i - idx);
                    idx = i;
                }
                // System.out.println(Arrays.toString(arr));
                
            }
        }

        return res;
    }

}