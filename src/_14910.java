import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.MIN_VALUE;
        while (st.hasMoreTokens()) {
            int curr = Integer.parseInt(st.nextToken());
            if (prev > curr) {
                System.out.println("Bad");
                return;
            }
            prev = curr;
        }
        System.out.println("Good");
    }

}
