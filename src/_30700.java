import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class _30700 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<Character> target = List.of('K', 'O', 'R', 'E', 'A');

        int result = 0;
        for (char value : str.toCharArray()) {
            if (value == target.get(result % 5)) {
                result++;
            }
        }

        System.out.println(result);

    }

}
