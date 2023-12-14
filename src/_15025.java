import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15025 {

    private static final String ODD = "Odd";
    private static final String EVEN = "Even";
    private static final String NOT_A_MOOSE = "Not a moose";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        int point = Math.max(left, right) * 2;
        if (point == 0) {
            System.out.println(NOT_A_MOOSE);
            return;
        }
        String type = left == right ? EVEN : ODD;
        System.out.printf("%s %d\n", type, point);
    }

}
