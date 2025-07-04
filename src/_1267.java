import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1267 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = 0;
        int M = 0;
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(st.nextToken());
            Y += (value / 30 + 1) * 10;
            M += (value / 60 + 1) * 15;
        }
        if (Y < M) {
            System.out.printf("%c %d\n", 'Y', Y);
        }
        else if (Y > M) {
            System.out.printf("%c %d\n", 'M', M);
        }
        else {
            System.out.printf("Y M %d\n", M);
        }
    }

}
