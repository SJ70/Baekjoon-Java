import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class _6948 {

    private static Map<Character, List<Character>> childrenMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String input = br.readLine();
            char parent = input.charAt(0);
            char child = input.charAt(11);

            if (!childrenMap.containsKey(parent)) {
                List<Character> list = new ArrayList<>();
                childrenMap.put(parent, list);
            }
            childrenMap.get(parent)
                    .add(child);

            if (!childrenMap.containsKey(child)) {
                List<Character> list = new ArrayList<>();
                childrenMap.put(child, list);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c = 'A'; c <= 'Z'; c++) {
            if (childrenMap.containsKey(c)) {
                Set<Character> visited = new HashSet<>();
                List<Character> result = new ArrayList<>();
                visited.add(c);
                visit(c, visited, result);

                String resultStr = result.stream()
                        .map(String::valueOf)
                        .sorted()
                        .collect(Collectors.joining(","));
                String formattedStr = String.format("%c = {%s}\n", c, resultStr);
                sb.append(formattedStr);
            }
        }
        System.out.print(sb);
    }

    private static void visit(Character parent, Set<Character> visited, List<Character> result) {
        if (childrenMap.get(parent) == null) {
            return;
        }
        for (char child : childrenMap.get(parent)) {
            if (visited.contains(child)) {
                continue;
            }
            if (child >= 'a' && child <= 'z') {
                result.add(child);
            }
            visited.add(child);
            visit(child, visited, result);
        }
    }

}
