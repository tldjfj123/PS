import java.util.*;
import java.io.*;

public class Main {
    static int n, maxX, maxY, minX, minY;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];

        maxX = Integer.MIN_VALUE;
        maxY = Integer.MIN_VALUE;

        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            minX = Math.min(x, minX);
            minY = Math.min(y, minY);
            maxX = Math.max(x, maxX);
            maxY = Math.max(y, maxY);

            arr[i] = new int[] {x, y};
        }


        if (isOk(arr)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    /*
    선 3개를 정해야함
    아래는 경우의 수 
    x x x
    x x y
    x y y
    y y y
    */

    static boolean isOk(int[][] arr) {
        
        // 1. xxx
        for (int i = minX; i <= maxX; i++) {
            for (int j = i+1; j<= maxX; j++) {
                for (int k = j+1; k <= maxX; k++) {

                    boolean[] check = new boolean[n];

                    for (int t = 0; t < arr.length; t++) { // 전체 점을 돌면서 포함 확인
                        if (arr[t][0] == i || arr[t][0] == j || arr[t][0] == k) {
                            check[t] = true;
                        }
                    }

                    int cnt = 0;
                    for (int t = 0; t < n; t++) {
                        if (check[t]) {
                            cnt++;
                        }
                    }

                    if (cnt == n) {
                        return true;
                    }
                }
            }
        }
        
        // 2. xxy
        for (int i = minX; i <= maxX; i++) {
            for (int j = i+1; j<= maxX; j++) {
                for (int k = minY; k <= maxY; k++) {

                    boolean[] check = new boolean[n];

                    for (int t = 0; t < arr.length; t++) { // 전체 점을 돌면서 포함 확인
                        if (arr[t][0] == i || arr[t][0] == j || arr[t][1] == k) {
                            check[t] = true;
                        }
                    }

                    int cnt = 0;
                    for (int t = 0; t < n; t++) {
                        if (check[t]) {
                            cnt++;
                        }
                    }   


                    if (cnt == n) {
                        return true;
                    }
                }
            }
        }
        

        // 3. xyy
        for (int i = minY; i <= maxY; i++) {
            for (int j = i+1; j<= maxY; j++) {
                for (int k = minX; k <= maxX; k++) {

                    boolean[] check = new boolean[n];

                    for (int t = 0; t < arr.length; t++) { // 전체 점을 돌면서 포함 확인
                        if (arr[t][1] == i || arr[t][1] == j || arr[t][0] == k) {
                            check[t] = true;
                        }
                    }

                    int cnt = 0;
                    for (int t = 0; t < n; t++) {
                        if (check[t]) {
                            cnt++;
                        }
                    }



                    if (cnt == n) {
                        return true;
                    }
                }
            }
        }

        // 4. yyy
        for (int i = minY; i <= maxY; i++) {
            for (int j = i+1; j<= maxY; j++) {
                for (int k = j+1; k <= maxY; k++) {

                    boolean[] check = new boolean[n];

                    for (int t = 0; t < arr.length; t++) { // 전체 점을 돌면서 포함 확인
                        if (arr[t][1] == i || arr[t][1] == j || arr[t][1] == k) {
                            check[t] = true;
                        }
                    }

                    int cnt = 0;
                    for (int t = 0; t < n; t++) {
                        if (check[t]) {
                            cnt++;
                        }
                    }



                    if (cnt == n) {
                        return true;
                    }
                }
            }
        }
        
        
        return false;
    }
}