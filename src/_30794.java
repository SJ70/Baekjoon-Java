import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30794 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        switch (st.nextToken()) {
            case "miss" :
                System.out.println(0);
                break;
            case "bad" :
                System.out.println(n * 200);
                break;
            case "cool" :
                System.out.println(n * 400);
                break;
            case "great" :
                System.out.println(n * 600);
                break;
            case "perfect" :
                System.out.println(n * 1000);
                break;
        }

    }

}
