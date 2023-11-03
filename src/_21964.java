import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _21964 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(str.substring(n-5));
    }

}
