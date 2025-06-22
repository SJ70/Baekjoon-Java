import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _18198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        int a = 0;
        int b = 0;
        int targetScore = 11;
        for (int i=0; i<length; i+=2) {
            char team = str.charAt(i);
            int score = str.charAt(i + 1) - '0';

            if (team == 'A') {
                a += score;
            }
            else {
                b += score;
            }

            if (a >= targetScore) {
                System.out.println('A');
                return;
            }
            else if (b >= targetScore) {
                System.out.println('B');
                return;
            }
            else if (a == targetScore - 1 && a == b) {
                targetScore += 1;
            }
        }
        if (a > b) {
            System.out.println('A');
        }
        else {
            System.out.println('B');
        }
    }

}
