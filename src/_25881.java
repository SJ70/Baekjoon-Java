import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25881 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pricePerUntil1000 = Integer.parseInt(st.nextToken());
        int pricePerOver1000 = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(br.readLine());
            int priceUntil1000 = Math.min(value, 1000) * pricePerUntil1000;
            int priceOver1000 = Math.max(value - 1000, 0) * pricePerOver1000;
            int price = priceUntil1000 + priceOver1000;
            String result = String.format("%d %d\n", value, price);
            sb.append(result);
        }
        System.out.print(sb);

    }

}
