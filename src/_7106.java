import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _7106 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> values = new ArrayList<>();
        boolean[] visited = new boolean[5];
        for (int a=0; a<5; a++) {
            if (nums[a] == 0 || visited[a]) {
                continue;
            }
            visited[a] = true;
            for (int b=0; b<5; b++) {
                if (visited[b]) {
                    continue;
                }
                visited[b] = true;
                for (int c=0; c<5; c++) {
                    if (visited[c]) {
                        continue;
                    }
                    visited[c] = true;
                    for (int d=0; d<5; d++) {
                        if (visited[d]) {
                            continue;
                        }
                        visited[d] = true;
                        for (int e=0; e<5; e++) {
                            if (visited[e]) {
                                continue;
                            }
                            visited[e] = true;

                            int value = nums[a] * 10000 + nums[b] * 1000 + nums[c] * 100 + nums[d] * 10 + nums[e];
                            values.add(value);

                            visited[e] = false;
                        }
                        visited[d] = false;
                    }
                    visited[c] = false;
                }
                visited[b] = false;
            }
            visited[a] = false;
        }
        values = values.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(values);

        int result = 0;
        for (int a=0; a<values.size(); a++) {
            for (int b=a+1; b<values.size(); b++) {
                for (int c=b+1; c<values.size(); c++) {
                    int sum = values.get(a) + values.get(b) + values.get(c);
                    if (set.contains(sum)) {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }



}
