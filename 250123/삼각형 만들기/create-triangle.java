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
                        maxArea = Math.max(maxArea, getTriangleArea(arr[i], arr[j], arr[k]));
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

    // 직각 삼각형 넓이 계산
    static int getTriangleArea(int[] p1, int[] p2, int[] p3) {
        int base = 0, height = 0;

        if (p1[1] == p2[1]) { // p1 - p2가 x축과 평행한 변
            base = Math.abs(p1[0] - p2[0]);
            height = Math.abs(p1[1] - p3[1]); // p1 - p3가 y축과 평행한 변
        } else if (p1[1] == p3[1]) { // p1 - p3가 x축과 평행한 변
            base = Math.abs(p1[0] - p3[0]);
            height = Math.abs(p1[1] - p2[1]); // p1 - p2가 y축과 평행한 변
        } else { // p2 - p3가 x축과 평행한 변
            base = Math.abs(p2[0] - p3[0]);
            height = Math.abs(p2[1] - p1[1]); // p2 - p1가 y축과 평행한 변
        }

        return base * height; // 삼각형 넓이 (1/2 없이 직사각형 면적)
    }
}
