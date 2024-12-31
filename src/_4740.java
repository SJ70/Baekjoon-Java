import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4740 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("***")) {
                break;
            }
            StringBuilder sb = new StringBuilder(input);
            result.append(sb.reverse());
            result.append('\n');
        }
        System.out.print(result);
    }

}
