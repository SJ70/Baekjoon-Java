import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2712 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double value = Double.parseDouble(st.nextToken());
            String unit = st.nextToken();

            switch (unit) {
                case "kg" :
                    sb.append(String.format("%.4f lb\n", value * 2.2046));
                    break;
                case "lb" :
                    sb.append(String.format("%.4f kg\n", value * 0.4536));
                    break;
                case "l" :
                    sb.append(String.format("%.4f g\n", value * 0.2642));
                    break;
                case "g" :
                    sb.append(String.format("%.4f l\n", value * 3.7854));
                    break;
            }
        }
        System.out.print(sb);
    }

}
