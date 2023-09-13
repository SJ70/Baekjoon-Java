import java.io.*;

public class _29699 {
    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()) - 1;
        final String str = "WelcomeToSMUPC";
        System.out.println(str.charAt(n%14));
    }
}
