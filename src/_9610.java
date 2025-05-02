import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[5];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == 0 || y == 0) {
                arr[4]++;
                continue;
            }
            if (x > 0 && y > 0) {
                arr[0]++;
                continue;
            }
            if (x < 0 && y > 0) {
                arr[1]++;
                continue;
            }
            if (x < 0 && y < 0) {
                arr[2]++;
                continue;
            }
            if (x > 0 && y < 0) {
                arr[3]++;
            }
        }
        System.out.printf("Q1: %d\n", arr[0]);
        System.out.printf("Q2: %d\n", arr[1]);
        System.out.printf("Q3: %d\n", arr[2]);
        System.out.printf("Q4: %d\n", arr[3]);
        System.out.printf("AXIS: %d\n", arr[4]);
    }

}
