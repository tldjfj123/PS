import java.util.*;
import java.io.*;


public class Main {
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};
    static int x, y, idx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받은 String char 배열로 변환
        String order = st.nextToken();
        char[] orders = order.toCharArray();
        
        //좌표 및 방향변수 초기화
        x = 0;
        y = 0;
        idx = 0;

        //for문 돌면서 명령 확인 후, 수행
        for (char o : orders) {
            if (o == 'L') {
                if (idx == 0) {
                    idx = 3;
                } else {
                    idx -= 1;
                }
            } else if (o == 'R') {
                if (idx == 3) {
                    idx = 0;
                } else {
                    idx += 1;
                }
            } else { //F
                x += dx[idx];
                y += dy[idx];
            }
        }

        System.out.println(x + " " + y);





        
    }
}