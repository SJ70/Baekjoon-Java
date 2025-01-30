import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            System.out.println(((str.charAt(str.length() - 1) - '0') % 2 == 0) ? "even" : "odd");
        }
    }

}
