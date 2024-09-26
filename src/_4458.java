import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t=0; t<T; t++) {
            String str = br.readLine();
            sb.append(str.toUpperCase().charAt(0));
            sb.append(str.substring(1));
            sb.append('\n');
        }
        System.out.print(sb);

    }

}
