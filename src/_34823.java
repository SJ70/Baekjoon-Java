import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _34823 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = Integer.MAX_VALUE;
        result = Math.min(result, Integer.parseInt(st.nextToken()));
        result = Math.min(result, Integer.parseInt(st.nextToken()) / 2);
        result = Math.min(result, Integer.parseInt(st.nextToken()));
        System.out.println(result);
    }

}
