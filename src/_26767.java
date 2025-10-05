import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26767 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            boolean divBy7 = i % 7 == 0;
            boolean divBy11 = i % 11 == 0;
            if (divBy7 && divBy11) {
                sb.append("Wiwat!");
            } else if (divBy7) {
                sb.append("Hurra!");
            } else if (divBy11) {
                sb.append("Super!");
            } else {
                sb.append(i);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
