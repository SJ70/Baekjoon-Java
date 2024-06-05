import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2935 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        char operator = br.readLine().charAt(0);
        String b = br.readLine();

        int aLength = a.length();
        int bLength = b.length();

        if (operator == '*') {
            System.out.println("1" + "0".repeat(aLength + bLength - 2));
        }
        else if (aLength == bLength) {
            System.out.println("2" + "0".repeat(aLength - 1));
        }
        else {
            System.out.println(
                    "1" +
                    "0".repeat(Math.max(aLength, bLength) - 1 - Math.min(aLength, bLength)) +
                    "1" +
                    "0".repeat(Math.min(aLength, bLength) - 1)
            );
        }


    }

}
