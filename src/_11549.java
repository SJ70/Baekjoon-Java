import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int correctAnswer = Integer.parseInt(br.readLine());
        String string = br.readLine();
        String[] strings = string.split(" ");
        int answerCount = (int) Arrays.stream(strings)
                .map(Integer::parseInt)
                .filter(answer -> answer == correctAnswer)
                .count();
        System.out.println(answerCount);
    }

}
