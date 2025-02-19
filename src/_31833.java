import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _31833 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long a = Long.parseLong(Arrays.stream(br.readLine().split(" ")).map(String::valueOf).collect(Collectors.joining("")));
        long b = Long.parseLong(Arrays.stream(br.readLine().split(" ")).map(String::valueOf).collect(Collectors.joining("")));
        System.out.println(Math.min(a, b));
    }

}
