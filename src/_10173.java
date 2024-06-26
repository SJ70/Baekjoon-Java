import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10173 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("EOI")) {
                break;
            }
            sb.append(input.toLowerCase().contains("nemo") ? "Found\n" : "Missing\n");
        }

        System.out.print(sb);

    }

}
