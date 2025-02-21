import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9772 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            if (x == 0 || y == 0) {
                System.out.println("AXIS");
                if (x == y) {
                    return;
                }
                continue;
            }
            if (x < 0) {
                System.out.println(y < 0 ? "Q3" : "Q2");
            }
            else {
                System.out.println(y < 0 ? "Q4" : "Q1");
            }
        }
    }

}
