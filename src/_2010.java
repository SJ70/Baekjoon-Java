import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 1;
        for (int i=0; i<N; i++) {
            result += Integer.parseInt(br.readLine()) - 1;
        }
        System.out.println(result);
    }

}
