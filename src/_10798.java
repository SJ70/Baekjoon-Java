import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _10798 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> strings = Stream.generate(() -> {
                    try {
                        return br.readLine();
                    } catch (IOException e) {
                        return "";
                    }
                })
                .limit(5)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        for (int c = 0; c < 15; c++) {
            for (int r = 0; r < 5; r++) {
                String str = strings.get(r);
                if (c < str.length()) {
                    sb.append(str.charAt(c));
                }
            }
        }

        System.out.println(sb);

    }

}
