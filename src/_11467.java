import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int diff = Math.abs(b - w);
        int leftValue = (b - w > 0) ? 0 : 1;

        for (int i=0; i<diff; i++) {
            char l = leftValue == 0 ? '@' : '.';
            char r = leftValue == 1 ? '@' : '.';
            sb.append(l).append(r).append('\n');
            sb.append(r).append(r).append('\n');
        }

        int min = Math.min(b, w);
        for (int i=0; i<min; i++) {
            char l = leftValue == 0 ? '@' : '.';
            char r = leftValue == 1 ? '@' : '.';
            sb.append(l).append(r).append('\n');
            leftValue++;
            leftValue %= 2;
        }

        System.out.printf("%d %d\n", min + diff * 2, 2);
        System.out.print(sb);

    }

}
