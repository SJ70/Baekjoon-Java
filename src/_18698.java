import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _18698 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            String steps = br.readLine();
            int max_value = 0;
            int value = 0;
            for (int j=0; j<steps.length(); j++) {
                char step = steps.charAt(j);
                if (step == 'U') {
                    value++;
                    max_value = Math.max(value, max_value);
                }
                else {
                    break;
                }
            }
            sb.append(max_value).append('\n');
        }
        System.out.print(sb);
    }

}
