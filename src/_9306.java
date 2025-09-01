import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9306 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            String a = br.readLine();
            String b = br.readLine();
            System.out.printf("Case %d: %s, %s\n", t, b, a);
        }
    }


}
