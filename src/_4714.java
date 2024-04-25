import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4714 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        double value;

        while(true) {
            value = Double.parseDouble(br.readLine());
            if (value == -1f) {
                break;
            }
            sb.append(String.format("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n", value, value * 0.167));
        }

        System.out.print(sb);

    }

}
