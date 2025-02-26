import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[15];

        for (int i = 0; i < 15; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // System.out.println(Arrays.toString(arr));

        int total = arr[14];

        for (int i = 1; i <= 40; i++) {
            for (int j = i; j <= 40; j++) {
                for (int k =j; k <= 40; k++) {
                    for (int l = k; l <= 40; l++) {
                        if (isOk(i, j, k, l)) {
                            System.out.println(i + " " + j + " " + k + " " + l);
                        }
                    }
                }
            }
        }

    }

    static boolean isOk(int a, int b, int c, int d) {
        int[] tmp = new int[15];

        tmp[0] = a;
        tmp[1] = b; 
        tmp[2] = c;
        tmp[3] = d;
        tmp[4] = a + b;
        tmp[5] = b + c;
        tmp[6] = c + d;
        tmp[7] = d + a;
        tmp[8] = a + c;
        tmp[9] = b + d;
        tmp[10] = a + b + c;
        tmp[11] = a + b + d;
        tmp[12] = a + c + d;
        tmp[13] = b + c + d;
        tmp[14] = a + b + c + d;


        Arrays.sort(tmp);

        for (int i = 0; i < 15; i++) {
            if (arr[i] != tmp[i]) {
                return false;
            }
        }

        return true;



    }
}