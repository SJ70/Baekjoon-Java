import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19572 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        double y = (double) (a - b + c) / 2;
        double z = (double) c - y;
        double x = (double) a - y;
        if (a == x + y && b == x + z && c == y + z && x > 0 && y > 0 && z > 0) {
            System.out.println(1);
            System.out.printf("%.1f %.1f %.1f\n", x, y, z);
        }
        else {
            System.out.println(-1);
        }
    }

}
