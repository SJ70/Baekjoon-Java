import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int s1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int s2 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int s = s1 + s2;
        int p = p1 + p2;
        if (s < p) {
            System.out.println("Persepolis");
        }
        else if (s > p) {
            System.out.println("Esteghlal");
        }
        else {
            if (s1 < p2) {
                System.out.println("Persepolis");
            }
            else if (s1 > p2) {
                System.out.println("Esteghlal");
            }
            else {
                System.out.println("Penalty");
            }
        }
    }

}
