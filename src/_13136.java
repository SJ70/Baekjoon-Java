import java.io.*;
import java.util.StringTokenizer;

public class _13136 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double r = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());
        double n = Double.parseDouble(st.nextToken());
        System.out.println((long)(Math.ceil(r/n) * Math.ceil(c/n)));
    }
}
