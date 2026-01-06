import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1500 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        int min = sum / cnt;
        int rest = sum % cnt;

        long result = 1;
        for (int i=0; i<cnt-rest; i++) {
            result *= min;
        }
        for (int i=0; i<rest; i++) {
            result *= min + 1;
        }
        System.out.println(result);
    }

}
