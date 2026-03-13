import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9241 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String from = br.readLine();
        String to = br.readLine();

        int left = 0;
        int fl = 0;
        int tl = 0;
        while (fl < from.length() && tl < to.length() && from.charAt(fl) == to.charAt(tl)) {
            fl++;
            tl++;
            left++;
        }

        int right = 0;
        int fr = from.length() - 1;
        int tr = to.length() - 1;
        while (fr >= 0 && tr >= 0 && from.charAt(fr) == to.charAt(tr)) {
            fr--;
            tr--;
            right++;
        }

        if (left + right > from.length()) {
            left = from.length() - right;
        }
        int result = to.length() - right - left;

        if (result < 0) {
            result = 0;
        }
        System.out.println(result);

    }

}
