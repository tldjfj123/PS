import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int setA = arr[0] + arr[5];
        int setB = arr[1] + arr[4];
        int setC = arr[2] + arr[3];

        int max = Math.max(setA, Math.max(setB, setC));
        int min = Math.min(setA, Math.min(setB, setC));

        System.out.println(Math.abs(max - min));
    }
}