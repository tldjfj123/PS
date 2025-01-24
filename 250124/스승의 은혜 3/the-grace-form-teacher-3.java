import java.util.*;
import java.io.*;

class Gift implements Comparable<Gift> {
    int price;
    int deliveryFee;

    public Gift(int price, int deliveryFee) {
        this.price = price;
        this.deliveryFee = deliveryFee;
    }

    @Override
    public int compareTo(Gift g) {
        return Integer.compare(this.deliveryFee, g.deliveryFee);
    }

    @Override
    public String toString() {
        return this.price + " " + this.deliveryFee;
    }

}


public class Main {
    static int n, b;
    static Gift[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arr = new Gift[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int price = Integer.parseInt(st.nextToken());
            int deliveryFee = Integer.parseInt(st.nextToken());

            arr[i] = new Gift(price, deliveryFee);
        }

        Arrays.sort(arr);

        // System.out.println(Arrays.toString(arr));

        // 쿠폰 적용할 선물 고르고, 예산 닿는데까지 최댓값 구하기
        int res = 0;
        for (int i = 0; i < n; i++) { // 쿠폰 적용할 선물
            int budget = b;
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    budget -= ((arr[j].price / 2) + arr[j].deliveryFee);

                    if (budget < 0) {
                        res = Math.max(cnt, res);
                    } else {
                        cnt++;
                    }
                } else {
                    budget -= (arr[j].price + arr[j].deliveryFee);

                    if (budget < 0) {
                        res = Math.max(cnt, res);
                    } else {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(res);
    }
}