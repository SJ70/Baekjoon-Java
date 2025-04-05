import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _6965 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            String result = Arrays.stream(str.split(" "))
                    .map(word -> (word.length() == 4) ? "****" : word)
                    .collect(Collectors.joining(" "));
            sb.append(result);
            sb.append('\n');
            if (i==N-1) {
                System.out.print(sb);
                return;
            }
            sb.append('\n');
        }
    }

}
