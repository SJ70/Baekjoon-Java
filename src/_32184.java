import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _32184 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if (A%2 == B%2) {
            System.out.println((B - A) / 2 + 1);
            return;
        }
        if (A%2 == 0) {
            System.out.println((B - A) / 2 + 2);
            return;
        }
        System.out.println((B + 1 - A) / 2);
    }

}
