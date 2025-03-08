import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23080 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<str.length(); i+=N) {
            sb.append(str.charAt(i));
        }
        System.out.println(sb);
    }

}
