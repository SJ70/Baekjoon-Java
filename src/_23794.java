import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23794 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.print("@".repeat(N+2));
        System.out.print('\n');
        for (int i=0; i<N; i++) {
            System.out.print("@");
            System.out.print(" ".repeat(N));
            System.out.print("@");
            System.out.print('\n');
        }
        System.out.print("@".repeat(N+2));
    }

}
