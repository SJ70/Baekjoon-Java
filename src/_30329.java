import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30329 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;
        for (int i=0; i<str.length() - 3; i++) {
            if (str.charAt(i) == 'k'
                    && str.charAt(i+1) == 'i'
                    && str.charAt(i+2) == 'c'
                    && str.charAt(i+3) == 'k'
            ) {
                result++;
                i+=2;
            }
        }
        System.out.println(result);
    }

}
