import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10179 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            double value = Double.parseDouble(br.readLine());
            double result = value * 0.8;
            String str = String.format("$%.2f\n", result);
            sb.append(str);
        }
        System.out.print(sb);
    }

}
