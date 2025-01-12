import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxScore = -1;
        int maxScoreIdx = -1;
        for (int i=1; i<=5; i++) {
            int score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
            if (score > maxScore) {
                maxScore = score;
                maxScoreIdx = i;
            }
        }
        System.out.printf("%d %d\n", maxScoreIdx, maxScore);
    }

}
