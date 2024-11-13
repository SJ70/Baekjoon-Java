import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2863 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double c = Double.parseDouble(st.nextToken());
        double d = Double.parseDouble(st.nextToken());

        double[] values = new double[4];
        values[0] = a/c + b/d;
        values[1] = c/d + a/b;
        values[2] = d/b + c/a;
        values[3] = b/a + d/c;
        double maxValue = Arrays.stream(values).max().getAsDouble();

        for (int i=0; i<4; i++) {
            if (values[i] == maxValue) {
                System.out.println(i);
                return;
            }
        }
    }

}
