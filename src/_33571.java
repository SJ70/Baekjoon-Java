import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _33571 {

    private static final char[] arr1 = new char[] {'a', 'A', 'b', 'D', 'd', 'e', 'g', 'o', 'O', 'p', 'P', 'q', 'Q', 'R', '@'};
    private static final char[] arr2 = new char[] {'B'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        loop: for (char c0 : br.readLine().toCharArray()) {
            for (char c1 : arr1) {
                if (c0 == c1) {
                    result++;
                    continue loop;
                }
            }
            for (char c1 : arr2) {
                if (c0 == c1) {
                    result += 2;
                    continue loop;
                }
            }
        }
        System.out.println(result);
    }

}
