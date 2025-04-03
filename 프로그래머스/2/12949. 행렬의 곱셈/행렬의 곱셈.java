import java.util.*;

class Solution {
    static int[][] res;
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 결과 행렬의 크기 : arr1의 row X arr2의 column
        res = new int[arr1.length][arr2[0].length];
        
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                //arr1의 열을  잡고, arr2의 행을 잡은 뒤 각각 곱한 뒤 더하기
                int tmp = 0;
                
                int row = arr1[i].length;
                int column = j;
                
                for (int k = 0; k < row; k++) {
                    tmp += arr1[i][k] * arr2[k][j];
                }
                
                res[i][j] = tmp;
                
            }
        }
        
        return res;
    }
}