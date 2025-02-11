import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6378 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }
            int value = 0;
            for (char c : str.toCharArray()) {
                value += c - '0';
                if (value > 9) {
                    value = value % 10 + 1;
                }
            }
            sb.append(value);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
