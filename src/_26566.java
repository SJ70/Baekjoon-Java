import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _26566 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            double a1 = Double.parseDouble(st.nextToken());
            double p1 = Double.parseDouble(st.nextToken());
            st = new StringTokenizer(br.readLine());
            double r1 = Double.parseDouble(st.nextToken());
            double a2 = r1 * r1 * Math.PI;
            double p2 = Double.parseDouble(st.nextToken());

            double value1 = a1/p1;
            double value2 = a2/p2;
            sb.append(value1 < value2 ? "Whole pizza\n" : "Slice of pizza\n");
        }
        System.out.print(sb);
    }

}
