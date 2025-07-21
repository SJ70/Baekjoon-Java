import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2783 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double result = Double.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        result = Math.min(result, Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken()) * 1000);
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            result = Math.min(result, Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken()) * 1000);
        }
        System.out.println(result);
    }

}
