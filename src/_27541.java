import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _27541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        if (str.charAt(N-1) == 'G') {
            System.out.println(str.substring(0, N-1));
        }
        else {
            System.out.println(str + 'G');
        }
    }

}
