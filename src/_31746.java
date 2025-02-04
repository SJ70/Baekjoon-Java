import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31746 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("SciComLove");
        if (n % 2 == 1) {
            sb.reverse();
        }
        System.out.println(sb);
    }

}
