import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class _10093 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(Math.max(0, Math.abs(b - a) - 1));
        for (long i = Math.min(a, b) + 1; i < Math.max(a, b); i++) {
            System.out.print(i);
            System.out.print(i == Math.max(a, b) - 1 ? '\n' : ' ');
        }
    }

}
