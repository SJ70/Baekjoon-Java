import java.io.*;
import java.util.StringTokenizer;

public class _15700 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
        System.out.println(N/2);
    }
}
