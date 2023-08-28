import java.io.*;
import java.util.StringTokenizer;

public class _23825 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int S = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        System.out.println(Math.min(S, A)/2);
    }
}
