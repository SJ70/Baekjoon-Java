import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        char o1 = st.nextToken().charAt(0);
        int n2 = Integer.parseInt(st.nextToken());
        char o2 = st.nextToken().charAt(0);
        int n3 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        switch (o1) {
            case '+' : result1 = n1 + n2; break;
            case '-' : result1 = n1 - n2; break;
            case '*' : result1 = n1 * n2; break;
            case '/' : result1 = n1 / n2; break;
        }
        switch (o2) {
            case '+' : result1 += n3; break;
            case '-' : result1 -= n3; break;
            case '*' : result1 *= n3; break;
            case '/' : result1 /= n3; break;
        }

        int result2 = 0;
        switch (o2) {
            case '+' : result2 = n2 + n3; break;
            case '-' : result2 = n2 - n3; break;
            case '*' : result2 = n2 * n3; break;
            case '/' : result2 = n2 / n3; break;
        }
        switch (o1) {
            case '+' : result2 = n1 + result2; break;
            case '-' : result2 = n1 - result2; break;
            case '*' : result2 = n1 * result2; break;
            case '/' : result2 = n1 / result2; break;
        }

        System.out.println(Math.min(result1, result2));
        System.out.println(Math.max(result1, result2));
    }

}
