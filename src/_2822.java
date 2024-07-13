import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _2822 {

    private static class Problem {
        int idx;
        int value;

        public Problem(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Problem> problems = new ArrayList<>();
        for (int i=1; i<=8; i++) {
            int value = Integer.parseInt(br.readLine());
            Problem problem = new Problem(i, value);
            problems.add(problem);
        }
        problems.sort((a, b) -> - a.value + b.value);

        int sum = 0;
        List<Integer> idxs = new ArrayList<>();
        for (int i=0; i<5; i++) {
            Problem problem = problems.get(i);
            sum += problem.value;
            idxs.add(problem.idx);
        }

        System.out.println(sum);
        System.out.println(idxs.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));

    }

}
