import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int res = 0;
        for (int i = x; i <= y; i++) {
            res = Math.max(res, getSum(i));
        }

        System.out.println(res);
    }
    

    //각 자릿수의 합 구하는 메소드 
    static int getSum(int x) {  
        int res = 0;

        while (x != 0) {
            res += x % 10;
            x /= 10;
        }

        return res;
    }
}