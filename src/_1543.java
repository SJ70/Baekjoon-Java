import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _1543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();
        String searchingString = br.readLine();

        String splitString = Arrays.stream(string.split(searchingString)).
                collect(Collectors.joining(""));

        int lengthDiff = string.length() - splitString.length();
        System.out.println(lengthDiff / searchingString.length());
    }

}
