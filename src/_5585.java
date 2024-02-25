import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5585 {

    public static void main(String[] args) throws IOException {

        int n = 1000 - Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int result = 0;

        int[] coins = new int[] {500, 100, 50, 10, 5, 1};
        for (int coin : coins) {
            result += n / coin;
            n %= coin;
        }

        System.out.println(result);

    }

}
