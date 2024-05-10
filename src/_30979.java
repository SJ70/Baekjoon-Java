import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _30979 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        System.out.println(T <= sum ? "Padaeng_i Happy" : "Padaeng_i Cry");
    }

}
