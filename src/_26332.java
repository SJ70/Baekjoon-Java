import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _26332 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int result = c * p - Math.max(0, c-1) * 2;
            sb.append(str);
            sb.append('\n');
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
