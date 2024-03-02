import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30468 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int stats = 0;
        for (int i=0; i<4; i++) {
            stats += Integer.parseInt(st.nextToken());
        }

        int needs = Integer.parseInt(st.nextToken()) * 4;

        System.out.println(Math.max(needs - stats, 0));

    }

}
