import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10820 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            int lower = 0;
            int upper = 0;
            int blank = 0;
            int number = 0;
            for (char c : input.toCharArray()) {
                if (c == ' ') {
                    blank++;
                }
                else if (c >= 'a' && c <= 'z') {
                    lower++;
                }
                else if (c >= 'A' && c <= 'Z') {
                    upper++;
                }
                else {
                    number++;
                }
            }
            String result = String.format("%d %d %d %d\n", lower, upper, number, blank);
            sb.append(result);
        }
        System.out.print(sb);

    }

}
