import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1373 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String bin = br.readLine();

        if (bin.equals("0")) {
            System.out.println(0);
            return;
        }

        int j = 0;
        int value = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            value += Math.pow(2, j) * (bin.charAt(i) - '0');
            j++;
            if (j==3) {
                sb.append(value);
                j = 0;
                value = 0;
            }
        }
        if (value > 0) {
            sb.append(value);
        }
        System.out.println(sb.reverse());
    }

}
