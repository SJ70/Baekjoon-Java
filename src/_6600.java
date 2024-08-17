import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6600 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double x3 = Double.parseDouble(st.nextToken());
            double y3 = Double.parseDouble(st.nextToken());
            double length1 = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
            double length2 = Math.sqrt(Math.pow(x1-x3, 2) + Math.pow(y1-y3, 2));
            double length3 = Math.sqrt(Math.pow(x3-x2, 2) + Math.pow(y3-y2, 2));
            double area = Math.abs(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)) / 2;
            double r = length1 * length2 * length3 / area / 4;
            double result = r * 3.141592653589793 * 2;
            System.out.printf("%.2f\n", result);
        }

    }

}
