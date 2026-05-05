import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int n = Integer.parseInt(input);

        printSentence(n);
        
    }

    private static void printSentence(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("12345^&*()_");
            System.out.println();
        }
    }
}