import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30224 {
    public static void main(String[] args) throws IOException {
        String inputString = new BufferedReader(new InputStreamReader(System.in)).readLine();

        int result = 0;

        if (isContainSeven(inputString)) {
            result += 2;
        }

        if (canBeDivideBySeven(Integer.parseInt(inputString))) {
            result ++;
        }

        System.out.println(result);
    }

    private static boolean isContainSeven(String str) {
        int length = str.length();
        for (int i=0; i<length; i++) {
            if (str.charAt(i) == '7') {
                return true;
            }
        }
        return false;
    }

    private static boolean canBeDivideBySeven(int number) {
        return number % 7 == 0;
    }
}
