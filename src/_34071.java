import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _34071 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int first = Integer.parseInt(br.readLine());
        int min = first;
        int max = first;
        for (int i=1; i<N; i++) {
            int value = Integer.parseInt(br.readLine());
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        if (first == min) {
            System.out.println("ez");
            return;
        }
        if (first == max) {
            System.out.println("hard");
            return;
        }
        System.out.println("?");
    }

}
