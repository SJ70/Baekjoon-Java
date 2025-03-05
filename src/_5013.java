import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5013 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        loop: for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=1; j<str.length(); j++) {
                if (str.charAt(j) == 'D' && str.charAt(j-1) == 'C') {
                    continue loop;
                }
            }
            result++;
        }
        System.out.println(result);
    }

}
