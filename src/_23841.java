import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _23841 {

    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static int R;
    private static int C;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        String result = Stream.generate(() -> input())
                .limit(R)
                .map(value -> decalcomanie(value))
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }

    private static String input() {
        try {
            return BR.readLine();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static String decalcomanie(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C; i++) {
            char left = str.charAt(i);
            char right = str.charAt(C - 1 - i);
            sb.append(left == '.' ? right : left);
        }
        return sb.toString();
    }

}
