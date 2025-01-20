import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        //입력 받기
        int n = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());

        //for문 돌면서 홀수번 째 마다 중앙 값 출력
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));

            if (i % 2 == 0) {
                Collections.sort(arr);
                System.out.print(arr.get(arr.size()/2) + " ");
            }
        }

    }
}