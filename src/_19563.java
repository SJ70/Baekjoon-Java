import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19563 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int distance = Math.abs(a) + Math.abs(b);

        int moveCnt = Integer.parseInt(st.nextToken());

        boolean canGo = distance <= moveCnt && distance % 2 == moveCnt % 2;

        System.out.println(canGo ? "YES" : "NO");

    }

}
