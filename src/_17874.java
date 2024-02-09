import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long h = Long.parseLong(st.nextToken());
        long v = Long.parseLong(st.nextToken());

        System.out.println(4 * Math.max(h, n - h) * Math.max(v, n - v));
    }

}
