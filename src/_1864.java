import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("#")) {
                break;
            }
            sb.append(getNumberValue(str));
            sb.append('\n');
        }

        System.out.print(sb);

    }

    private static long getNumberValue(String str) {
        int value = 0;
        long digit = (long) Math.pow(8, str.length() - 1);
        for (char c : str.toCharArray()) {
            value += getNumberValue(c) * digit;
            digit /= 8;
        }
        return value;
    }

    private static long getNumberValue(char c) {
        switch (c) {
            case '-' : return 0;
            case '\\' : return 1;
            case '(' : return 2;
            case '@' : return 3;
            case '?' : return 4;
            case '>' : return 5;
            case '&' : return 6;
            case '%' : return 7;
            case '/' : return -1;
            default : return 0;
        }
    }

}
