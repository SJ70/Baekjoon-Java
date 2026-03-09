import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _34668 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        for (int q=0; q<Q; q++) {
            int M = Integer.parseInt(br.readLine());
            int time = 6 * 60 + 6;
            time += M / 50 * 12;
            System.out.printf("%02d:%02d\n", time / 60, time % 60);
        }
    }

}
