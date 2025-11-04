import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23304 {

    private static boolean result = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        recur(str);
        System.out.println(result ? "AKARAKA" : "IPSELENTI");
    }

    private static boolean isPal(String str) {
        int n = str.length();
        for (int i=0; i<n/2; i++) {
            char left = str.charAt(i);
            char right = str.charAt(n-1-i);
            if (left != right) {
                return false;
            }
        }
        return true;
    }

    private static void recur(String str) {
        if (str.length() == 1) {
            return;
        }
        if (!isPal(str)) {
            result = false;
        }
        if (!result) {
            return;
        }
        String left = str.substring(0, str.length() / 2);
        String right = str.substring((str.length() + 1) / 2);
        recur(left);
        recur(right);
    }

}
