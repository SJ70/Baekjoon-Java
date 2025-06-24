import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _85735 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        if (S <= A) {
            System.out.println(250);
            return;
        }
        int bCnt = ((S - A + B - 1) / B);
        int result = 250 + 100 * bCnt;
        System.out.println(result);
    }

}
