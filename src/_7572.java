import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7572 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 'A' + (N + 8) % 12;
        int b = (N + 6) % 10;
        StringBuilder sb = new StringBuilder();
        sb.append((char) a);
        sb.append(b);
        System.out.println(sb);
    }

}
