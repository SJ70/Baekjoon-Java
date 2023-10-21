import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _29863 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int from = Integer.parseInt(br.readLine());
        int until = Integer.parseInt(br.readLine());
        int diff = until - from;
        int result = diff > 0 ? diff : diff + 24;
        System.out.println(result);
    }

}
