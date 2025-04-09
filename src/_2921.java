import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i=0; i<=N; i++) {
            for (int j=i; j<=N; j++) {
                result += i;
                result += j;
            }
        }
        System.out.println(result);
    }

}
