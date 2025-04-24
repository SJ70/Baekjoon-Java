import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23811 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String l = ("@@@@@".repeat(N) + '\n').repeat(N);
        String s = ("@".repeat(N) + '\n').repeat(N);
        System.out.print(l);
        System.out.print(s);
        System.out.print(l);
        System.out.print(s);
        System.out.print(l);
    }

}
