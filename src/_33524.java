import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _33524 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] difficulties = new int[1000001];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int difficulty = Integer.parseInt(st.nextToken());
            difficulties[difficulty]++;
        }
        for (int i=1; i<=1000000; i++) {
            difficulties[i] += difficulties[i-1];
        }

        int[] counts = new int[1000001];
        for (int k=1; true; k++) {
            int count = 3 * k * (k-1) + 1;
            if (count > 1000000) {
                break;
            }
            counts[count] = k;
        }
        for (int i=2; i<=1000000; i++) {
            if (counts[i] == 0) {
                counts[i] = counts[i-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int value = Integer.parseInt(st.nextToken());
            int result = counts[difficulties[value]];
            sb.append(result);
            sb.append(i == M-1 ? '\n' : ' ');
        }
        System.out.print(sb);
    }

}
