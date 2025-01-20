import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static String t;
    static String[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        t = st.nextToken();

        arr = new String[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }
        

        List<String> filtered = new ArrayList<String>();
        // for문을 돌며 해당하는 것만 살려놓기
        for (String a : arr) {
            if (isStartWithT(a)) {
                filtered.add(a);
            }
        }

        Collections.sort(filtered);

        // System.out.println(filtered);

        System.out.println(filtered.get(k-1));
    }

    static boolean isStartWithT(String s) {
        int range = t.length();

        if (s.substring(0, range).equals(t)) {
            return true;
        }

        return false;
    }   
}   