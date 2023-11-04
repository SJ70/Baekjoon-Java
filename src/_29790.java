import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _29790 {

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        boolean good = n >= 1000;
        boolean level = u >= 8000 || l >= 260;

        if (good && level) {
            System.out.println("Very Good");
            return;
        }
        if (good) {
            System.out.println("Good");
            return;
        }
        System.out.println("Bad");

    }

}
