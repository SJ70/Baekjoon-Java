import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24356 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int min = (t2*60 + m2) - (t1*60 + m1);
        if (min < 0) {
            min += 60*24;
        }
        int cnt = min / 30;
        System.out.printf("%d %d\n", min, cnt);
    }

}
