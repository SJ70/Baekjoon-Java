import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25991 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double result = 0;
        for (int i=0; i<N; i++) {
            double value = Double.parseDouble(st.nextToken());
            result += (value * value * value);
        }
        System.out.println(Math.cbrt(result));
    }

}
