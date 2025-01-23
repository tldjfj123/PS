import java.util.*;
import java.io.*;

class Time {
    int startTime;
    int endTime;

    public Time(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return this.startTime + " " + this.endTime;
    }
}

public class Main {
    static Time[] arr;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new Time[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            arr[i] = new Time(startTime, endTime);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, checkWorkingTime(arr, i));
        }

        System.out.println(res);


    }

    //운행되고 있는 시간 확인하는 메소드
    static int checkWorkingTime(Time[] arr, int passIdx) {
        int[] timeTable = new int[1000];

        for (int i = 0; i < n; i++) {
            if (i == passIdx) {
                continue;
            }

            for (int j = arr[i].startTime; j < arr[i].endTime; j++) {
                if (timeTable[j-1] == 0) {
                    timeTable[j-1]++;
                }
            }    
        }
        
        int cnt = 0;
        for (int i = 0; i < 1000; i++) {
            if (timeTable[i] == 1) {
                cnt++;
            }
        }

        return cnt;
    }
}