import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _30924 {

    private static final int MIN = 1;
    private static final int MAX = 10000;
    private static final int MAX_QUESTION_COUNT = 19997;
    private static int currentQuestionCount = 0;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int a = getValue('A');
        int b = getValue('B');
        System.out.printf("! %d\n", a + b);
    }

    private static int getValue(char name) throws IOException {
        Set<Integer> remainedNumbers = new HashSet<>();
        for (int i=MIN; i<=MAX; i++) {
            remainedNumbers.add(i);
        }

        // 질문
        while (currentQuestionCount < MAX_QUESTION_COUNT) {

            // 남은 숫자가 하나
            if (remainedNumbers.size() == 1) {
                List<Integer> numbers = remainedNumbers.stream().collect(Collectors.toList());
                return numbers.get(0);
            }

            currentQuestionCount++;
            List<Integer> numbers = remainedNumbers.stream().collect(Collectors.toList());
            int randomIndex = (int)(Math.random() * numbers.size());
            int randomNumber = numbers.get(randomIndex);
            remainedNumbers.remove(randomNumber);
            System.out.printf("? %c %d\n", name, randomNumber);
            if (br.readLine().equals("1")) {
                return randomNumber;
            }
        }

        // 질문 횟수 소진
        List<Integer> numbers = remainedNumbers.stream().collect(Collectors.toList());
        int randomIndex = (int)(Math.random() * numbers.size());
        int randomNumber = numbers.get(randomIndex);
        return randomNumber;
    }

}
