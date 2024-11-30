import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class _2966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String correctAnswer = br.readLine();
        int adrianScore = 0;
        int brunoScore = 0;
        int goranScore = 0;
        for (int i=0; i<N; i++) {
            int value = correctAnswer.charAt(i);
            if ("ABC".charAt(i%3) == value) {
                adrianScore++;
            }
            if ("BABC".charAt(i%4) == value) {
                brunoScore++;
            }
            if ("CCAABB".charAt(i%6) == value) {
                goranScore++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int maxScore = -1;

        if (adrianScore > maxScore) {
            sb = new StringBuilder();
            maxScore = adrianScore;
        }
        if (adrianScore == maxScore) {
            sb.append("Adrian\n");
        }

        if (brunoScore > maxScore) {
            sb = new StringBuilder();
            maxScore = brunoScore;
        }
        if (brunoScore == maxScore) {
            sb.append("Bruno\n");
        }

        if (goranScore > maxScore) {
            sb = new StringBuilder();
            maxScore = goranScore;
        }
        if (goranScore == maxScore) {
            sb.append("Goran\n");
        }

        System.out.println(maxScore);
        System.out.print(sb);

    }

}
