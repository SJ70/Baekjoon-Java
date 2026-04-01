import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21638 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        if (c<0 && d>=10) {
            System.out.println("A storm warning for tomorrow! Be careful and stay home if possible!");
            return;
        }
        if (c<a) {
            System.out.println("MCHS warns! Low temperature is expected tomorrow.");
            return;
        }
        if (c>=a && d>b) {
            System.out.println("MCHS warns! Strong wind is expected tomorrow.");
            return;
        }
        System.out.println("No message");
    }

}
