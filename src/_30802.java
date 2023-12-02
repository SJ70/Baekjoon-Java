import java.io.*;
import java.util.*;

public class _30802 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int[] sizes;
    private static int shirts_standard;
    private static int pens_standard;

    public static void main(String[] args) throws IOException {
        init();

        int result = 0;
        for (int size : sizes) {
            result += size / shirts_standard;
            result += size % shirts_standard > 0 ? 1 : 0;
        }

        System.out.printf(
                "%d\n%d %d",
                result,
                n / pens_standard,
                n % pens_standard
        );

    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        sizes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        shirts_standard = Integer.parseInt(st.nextToken());
        pens_standard = Integer.parseInt(st.nextToken());
    }

}
