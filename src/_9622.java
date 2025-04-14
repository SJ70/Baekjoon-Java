import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int stack = 0;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            double d = Double.parseDouble(st.nextToken());
            boolean bool = ((a<=56 && b<=45 && c<=25) || (a + b + c <= 125)) && (d <= 7);
            int result = bool ? 1 : 0;
            stack += result;
            sb.append(result);
            sb.append('\n');
        }
        sb.append(stack);
        System.out.println(sb);
    }

}
