import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31090 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            int year = Integer.parseInt(br.readLine());
            int divider = year % 100;
            sb.append((year + 1) % divider == 0 ? "Good\n" : "Bye\n");
        }
        System.out.print(sb);
    }

}
