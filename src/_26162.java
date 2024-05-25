import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _26162 {

    public static void main(String[] args) throws IOException {

        boolean[] isNotDecimal = new boolean[119];
        isNotDecimal[1] = true;
        for (int i=2; i<=118; i++) {
            if (isNotDecimal[i]) {
                continue;
            }
            for (int j=i*2; j<=118; j+=i) {
                isNotDecimal[j] = true;
            }
        }

        Set<Integer> decimals = new HashSet<>();
        for (int i=2; i<=118; i++) {
            if (!isNotDecimal[i]) {
                decimals.add(i);
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        loop: for (int t=0; t<T; t++) {
            int value = Integer.parseInt(br.readLine());
            for (int decimal : decimals) {
                if (decimals.contains(value - decimal)) {
                    sb.append("Yes\n");
                    continue loop;
                }
            }
            sb.append("No\n");
        }

        System.out.print(sb);

    }

}
