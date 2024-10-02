import java.util.*;

class Main{
    static boolean[] visited;
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false; 
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }


    static boolean calc(int v) { //자릿수 합 연산
        visited = new boolean[1000000];
        visited[v] = true;

        while (true) {
            char[] arr = Integer.toString(v).toCharArray();

            int res = 0;

            for (int i = 0; i < arr.length; i++) {
                res += Math.pow(arr[i] - '0', 2);
            }
            
            if (res == 1) {
                return true;
            } else {
                if (visited[res]) {
                    return false;
                } else {
                    v = res;
                    visited[res] = true;
                }
            }

        }

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int t = 0; t < n; t++) {
            int caseNum = sc.nextInt();
            int v = sc.nextInt();

            if (calc(v)) {
                if (isPrime(v)) {
                    System.out.println(caseNum + " " + v + " " + "YES");
                } else {
                    System.out.println(caseNum + " " + v + " " + "NO");
                }
            } else {
                System.out.println(caseNum + " " + v + " " + "NO");
            }
        }
    }

}

