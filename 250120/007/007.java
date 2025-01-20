import java.util.*;
import java.io.*;

class Code {
    String secretCode;
    String meetingPoint;
    String time;

    public Code(String secretCode, String meetingPoint, String time) {
        this.secretCode = secretCode;
        this.meetingPoint = meetingPoint;
        this.time = time;
    }

    @Override
    public String toString() {
        return "secret code : " + secretCode + "\nmeeting point : " + meetingPoint + " \ntime : " + time;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String secretCode = st.nextToken();
        String meetingPoint = st.nextToken();
        String time = st.nextToken();

        Code code = new Code(secretCode, meetingPoint, time);

        System.out.println(code);

    }
}