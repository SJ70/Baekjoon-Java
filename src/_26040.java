import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _26040 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] values = Arrays.stream(br.readLine().split(" "))
                .collect(Collectors.joining())
                .toCharArray();
        StringBuilder sb = new StringBuilder();
        int diff = 'A' - 'a';
        loop: for (char c : str.toCharArray()) {
            for (char value : values) {
                if (value == c) {
                    sb.append((char)(c - diff));
                    continue loop;
                }
            }
            sb.append(c);
        }
        System.out.println(sb);
    }

}
