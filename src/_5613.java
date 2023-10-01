import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5613 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long result = Long.parseLong(br.readLine());

        while (true) {
            char operator = br.readLine().charAt(0);

            if (operator == '=') {
                break;
            }

            long value = Long.parseLong(br.readLine());

            switch (operator) {
                case '+' :
                    result += value;
                    break;
                case '-' :
                    result -= value;
                    break;
                case '*' :
                    result *= value;
                    break;
                case '/' :
                    result /= value;
                    break;
            }
        }

        System.out.println(result);
    }
}
