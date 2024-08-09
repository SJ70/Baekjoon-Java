import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _26534 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dice1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dice2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int win = 0;
        int lose = 0;
        for (int i : dice1) {
            for (int j : dice2) {
                if (i > j) {
                    win++;
                }
                if (i < j) {
                    lose++;
                }
            }
        }
        double result = ((double)win) / (win+lose);
        System.out.printf("%.5f", result);

    }

}
