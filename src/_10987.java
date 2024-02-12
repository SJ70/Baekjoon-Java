import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class _10987 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        List<Character> targets = List.of('a', 'e', 'i', 'o', 'u');
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (targets.contains(str.charAt(i))) {
                result++;
            }
        }
        System.out.println(result);
    }

}
