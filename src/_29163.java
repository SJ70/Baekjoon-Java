import java.io.*;
import java.util.Arrays;

public class _29163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        var even = Arrays.stream(input)
                .filter(token -> Integer.parseInt(token) % 2 == 0)
                .toArray();
        int evenCnt = even.length;
        int oddCnt = n - evenCnt;
        System.out.println( oddCnt < evenCnt ? "Happy" : "Sad" );
    }
}
