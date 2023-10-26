import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _17863 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Pattern pattern = Pattern.compile("^555\\d{4}$");
        Matcher matcher = pattern.matcher(input);

        System.out.println( matcher.matches() ? "YES" : "NO" );
    }

}
