import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31243 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = getDiff(new StringTokenizer(br.readLine()));
        int b = getDiff(new StringTokenizer(br.readLine()));
        int c = getDiff(new StringTokenizer(br.readLine()));
        if (a <= b && a <= c) {
            printTime(a);
        }
        else if (b <= a && b <= c) {
            printTime(b);
        }
        else {
            printTime(c);
        }
        if (a >= b && a >= c) {
            printTime(a);
        }
        else if (b >= a && b >= c) {
            printTime(b);
        }
        else {
            printTime(c);
        }
    }

    private static int getDiff(StringTokenizer st) {
        int a = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        if (b < a) {
            b += 24 * 60;
        }
        return b - a;
    }

    private static void printTime(int a) {
        System.out.printf("%d:%02d\n", a/60, a%60);
    }

}
