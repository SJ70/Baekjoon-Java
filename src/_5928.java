import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5928 {

    public static void main(String[] args) throws IOException {
        long start = getSingleTimeValue(11, 11, 11);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long end = getSingleTimeValue(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        );

        if (end < start) {
            System.out.println(-1);
            return;
        }
        System.out.println(end - start);
    }

    private static long getSingleTimeValue(int y, int h, int m) {
        return y * 24 * 60 + h * 60 + m;
    }

}
