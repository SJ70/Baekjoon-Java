import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int N = 0;
        Map<String, Integer> trees = new HashMap<>();
        while ((input = br.readLine()) != null) {
            N++;
            trees.put(input, trees.getOrDefault(input, 0) + 1);
        }
        List<String> sortedTrees = trees.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (String tree : sortedTrees) {
            sb.append(tree);
            sb.append(' ');
            sb.append(String.format("%.4f\n", trees.get(tree) * 100.0 / N));
        }
        System.out.print(sb);
    }

}
