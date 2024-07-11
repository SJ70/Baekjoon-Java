import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2846 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max_diff = 0;

        int start_height = Integer.parseInt(st.nextToken());
        int end_height = start_height;
        do {
            int height = Integer.parseInt(st.nextToken());
            if (end_height >= height) {
                start_height = height;
            }
            end_height = height;
            max_diff = Math.max(end_height - start_height, max_diff);
        } while (st.hasMoreTokens());

        System.out.println(max_diff);

    }

}
