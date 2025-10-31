import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r3 = Integer.parseInt(st.nextToken());
        int c3 = Integer.parseInt(st.nextToken());
        int b = Math.max(Math.abs(r3 - r1), Math.abs(c3 - c1));
        int d = Math.abs(r3 - r2) + Math.abs(c3 - c2);
        if (b == d) {
            System.out.println("tie");
        }
        if (b > d) {
            System.out.println("daisy");
        }
        if (b < d) {
            System.out.println("bessie");
        }
    }

}
