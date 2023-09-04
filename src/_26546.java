import java.io.*;
import java.util.StringTokenizer;

public class _26546 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append(getReverseSubString(str, from, to)).append('\n');
        }
        System.out.println(sb);
    }

    private static String getReverseSubString(String str, int from, int to){
        return str.substring(0, from) + str.substring(to);
    }
}
