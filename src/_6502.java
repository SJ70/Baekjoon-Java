import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6502 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=1; true; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            if (r == 0) {
                return;
            }
            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            boolean bool = (r*2)*(r*2) >= w*w + l*l;
            System.out.printf("Pizza %d %s on the table.\n", i, bool ? "fits" : "does not fit");
        }
    }

}
