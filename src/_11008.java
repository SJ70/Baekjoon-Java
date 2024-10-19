import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11008 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            String s = st.nextToken();
            String[] splits = p.split(s);
            int splitLength = Arrays.stream(splits).mapToInt(String::length).sum();
            int result = (p.length() - splitLength) / s.length() + splitLength;
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
