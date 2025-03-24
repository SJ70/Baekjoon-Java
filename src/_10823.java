import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10823 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int value = 0;
        String input;
        while ((input = br.readLine()) != null) {
            for (char c : input.toCharArray()) {
                if (c == ',') {
                    result += value;
                    value = 0;
                }
                else {
                    value *= 10;
                    value += c - '0';
                }
            }
        }
        System.out.println(result + value);
    }

}
