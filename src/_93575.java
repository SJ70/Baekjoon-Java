import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _93575 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w1 = Integer.parseInt(st.nextToken());
        int h1 = Integer.parseInt(st.nextToken());
        int w2 = Integer.parseInt(st.nextToken());
        int h2 = Integer.parseInt(st.nextToken());
        boolean result = (w1 >= w2 + 2) && (h1 >= h2 + 2);
        System.out.println(result ? 1 : 0);
    }

}
