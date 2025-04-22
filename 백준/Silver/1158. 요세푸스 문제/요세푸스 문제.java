import java.util.*;
import java.io.*;

public class Main {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //요세푸스 문제 구현을 위한 deque 선언
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        List<Integer> arr = new ArrayList<>();

        while (!deque.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                deque.addLast(deque.pollFirst());
            }

            arr.add(deque.pollFirst());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int a : arr) {
            sb.append(a);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length()-2);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");

        String res = sb.toString();

        System.out.println(res);
    }
}
