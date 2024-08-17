import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _9850 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int diff=0; diff<=25; diff++) {
            int diff_ = diff;
            String decrypted = Arrays.stream(input.split(""))
                    .map(str -> str.charAt(0))
                    .map(value -> change(value, diff_))
                    .map(String::valueOf)
                    .collect(Collectors.joining());
//            System.out.println(decrypted);
            if (decrypted.contains("CHIPMUNKS") && decrypted.contains("LIVE")) {
                System.out.println(decrypted);
                return;
            }
        }

    }

    private static Character change(char value, int diff) {
        if (value < 'A' || value > 'Z') {
            return value;
        }
        return (char) (((int) value + diff) % 26 + 'A');
    }

}
