import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxArea = 0;

        // 모든 점 조합 중 조건에 맞는 삼각형 찾기
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isRightTriangle(arr[i], arr[j], arr[k])) {
                        maxArea = Math.max(maxArea, getTriangleWidth(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }

        System.out.println(maxArea * 2);
    }

    // x축에 평행한 변 & y축에 평행한 변을 가지는 삼각형인지 확인
    static boolean isRightTriangle(int[] p1, int[] p2, int[] p3) {
        return (p1[1] == p2[1] && p1[0] == p3[0]) ||  // p1-p2 (x축 평행), p1-p3 (y축 평행)
               (p1[1] == p3[1] && p1[0] == p2[0]) ||  // p1-p3 (x축 평행), p1-p2 (y축 평행)
               (p2[1] == p3[1] && p2[0] == p1[0]);    // p2-p3 (x축 평행), p2-p1 (y축 평행)
    }

    // 기존 코드의 신발끈 공식(외적) 활용
    static int getTriangleWidth(int[] p1, int[] p2, int[] p3) {
        return Math.abs((p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1]) - 
                        (p2[0] * p1[1] + p3[0] * p2[1] + p1[0] * p3[1]));
    }
}
