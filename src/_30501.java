import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (char c : string.toCharArray()) {
                if (c == 'S') {
                    System.out.println(string);
                    return;
                }
            }
        }
    }

}
