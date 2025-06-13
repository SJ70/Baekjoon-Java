import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _33964 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<max-min; i++) {
            sb.append(1);
        }
        for (int i=max-min; i<max; i++) {
            sb.append(2);
        }
        System.out.println(sb);
    }

}
