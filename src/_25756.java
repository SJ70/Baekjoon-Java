import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25756 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double value = 0;
        for (int i=0; i<N; i++) {
            value = 1 - (1 - value) * (1 - Double.parseDouble(st.nextToken()) / 100);
            System.out.println(value * 100);
        }
    }

}
