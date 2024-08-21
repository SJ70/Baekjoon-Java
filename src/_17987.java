import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17987 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int minLength = input.length();
        StringBuilder sb = new StringBuilder();
        sb.append("AW".repeat(minLength/2));
        sb.append("HO");
        System.out.println(sb);

    }

}
