import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2804 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int aLength = A.length();
        int bLength = B.length();

        int aPos = 0;
        int bPos = 0;
        loop: for (int a=0; a<aLength; a++) {
            for (int b=0; b<bLength; b++) {
                if (A.charAt(a) == B.charAt(b)) {
                    aPos = a;
                    bPos = b;
                    break loop;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r=0; r<bLength; r++) {
            for (int c=0; c<aLength; c++) {
                sb.append( (r == bPos) ? A.charAt(c) : (c == aPos) ? B.charAt(r) : '.');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

}
