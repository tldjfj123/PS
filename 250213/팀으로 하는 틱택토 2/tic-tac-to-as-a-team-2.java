import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        // 1 ~ 9까지 팀을 맺게 하기

        int res = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = i+1; j <= 9; j++) {
                if (isOk(i, j)) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    // 가로 , 세로 , 대각 3가지 경우에 대해서 탐색
    static boolean isOk(int x, int y) {
        // 가로
        for (int i = 0; i < 3; i++) {
            int xCnt = 0;
            int yCnt = 0;

            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == x) {
                    xCnt++;
                } else if (arr[i][j] == y) {
                    yCnt++;
                }
            }

            if ((xCnt == 2 && yCnt == 1) || (xCnt == 1 && yCnt == 2)) {
                return true;
            }
        }
        
        // 세로
        for (int i = 0; i < 3; i++) {
            int xCnt = 0;
            int yCnt = 0;

            for (int j = 0; j < 3; j++) {
                if (arr[j][i] == x) {
                    xCnt++;
                } else if (arr[j][i] == y) {
                    yCnt++;
                }
            }

            if ((xCnt == 2 && yCnt == 1) || (xCnt == 1 && yCnt == 2)) {
                return true;
            }
        }



        // 대각 \ 00 11 22
        int xCnt = 0;
        int yCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i][i] == x) {
                xCnt++; 
            } else if (arr[i][i] == y)  {
                yCnt++;
            }
        }

        if ((xCnt == 2 && yCnt == 1) || (xCnt == 1 && yCnt == 2)) {
            return true;
        }
        


        // 대각 / 02 11 20
        xCnt = 0;
        yCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i][2-i] == x) {
                xCnt++;
            } else if (arr[i][2-i] == y) {
                yCnt++;
            }
        }

        if ((xCnt == 2 && yCnt == 1) || (xCnt == 1 && yCnt == 2)) {
            return true;
        }


        return false;
    }
}