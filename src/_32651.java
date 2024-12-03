import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32651 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((N < 100000 && N % 2024 == 0) ? "Yes" : "No");

    }

}
