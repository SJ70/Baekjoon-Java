import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5361 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double result = 0;
            result += 350.34 * Integer.parseInt(st.nextToken());
            result += 230.90 * Integer.parseInt(st.nextToken());
            result += 190.55 * Integer.parseInt(st.nextToken());
            result += 125.30 * Integer.parseInt(st.nextToken());
            result += 180.90 * Integer.parseInt(st.nextToken());
            System.out.printf("$%.2f\n", result);;
        }
    }

}
