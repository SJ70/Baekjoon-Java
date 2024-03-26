import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16693 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        double aArea = Double.parseDouble(st.nextToken());
        double aPrice = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double bArea = Math.pow(Double.parseDouble(st.nextToken()), 2) * Math.PI;
        double bPrice = Double.parseDouble(st.nextToken());

        System.out.println(aArea / aPrice < bArea / bPrice ? "Whole pizza" : "Slice of pizza");

    }

}
