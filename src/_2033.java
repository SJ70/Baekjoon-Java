import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2033 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long value = Long.parseLong(br.readLine());
        int length = (int) Math.log10(value) + 1;
        for (int i=1; i<length; i++) {
            long o = (long) Math.pow(10, i);
            if (value % o >= o / 10 * 5) {
                value += o - value % o;
            }
            if (value % o < o / 10 * 5) {
                value -= value % o;
            }
        }
        System.out.println(value);
    }

}
