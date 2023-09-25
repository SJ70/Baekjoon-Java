import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _14241 {

    private static int score = 0;

    private static class Slimes {
        Deque<Integer> slimes;

        public Slimes (PriorityQueue<Integer> values) {
            slimes = new ArrayDeque<>(values);
        }

        public boolean isMergedAll() {
            return slimes.size() == 1;
        }

        public Slimes merge() {
            PriorityQueue<Integer> newSlimes = new PriorityQueue<>();

            while (slimes.size() > 1) {
                int smallest = slimes.pollFirst();
                int largest = slimes.pollLast();
                score += smallest * largest;
                int newSlime = smallest + largest;
                newSlimes.add(newSlime);
            }

            if (slimes.size() == 1) {
                int restOne = slimes.pop();
                newSlimes.add(restOne);
            }

            return new Slimes(newSlimes);
        }
    }


    public static void main(String[] args) throws IOException {
        Slimes slimes = new Slimes(input());
        while (!slimes.isMergedAll()) {
            slimes = slimes.merge();
        }
        System.out.println(score);
    }

    private static PriorityQueue<Integer> input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String inputString = br.readLine();
        String[] stringValues = inputString.split(" ");
        List<Integer> valuesList = Arrays.stream(stringValues)
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());
        PriorityQueue<Integer> values = new PriorityQueue<>(valuesList);
        return values;
    }
}
