import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        printBox(n);
    }

    private static void printBox(int n) {
        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = i+1;
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[idx] + " ");
                idx++;

                if (idx > 8) {
                    idx = 0;
                }
            }
            System.out.println();

        }
    }
}