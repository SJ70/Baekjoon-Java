import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _5948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> visited = new HashSet<>();

        String str = br.readLine();
        int result = 1;
        for (; ; result++) {
            str = "0".repeat(4 - str.length()) + str;
            int value = Integer.parseInt(str.substring(1, 3));
            if (visited.contains(value)) {
                break;
            }
            visited.add(value);
            str = String.valueOf(value * value);
        }
        System.out.println(result);
    }

}
