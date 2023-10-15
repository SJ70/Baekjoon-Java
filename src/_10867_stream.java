import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _10867_stream {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        List<Integer> list = Arrays.stream(input)
                .map(Integer::parseInt)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num).append(' ');
        }
        System.out.println(sb);

    }

}
