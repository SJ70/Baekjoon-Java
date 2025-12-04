import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _24912 {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] != 0 && get(i-1) == arr[i]) {
                System.out.println(-1);
                return;
            }
        }

        for (int i=0; i<N; i++) {
            if (arr[i] != 0) {
                continue;
            }
            if (get(i-1) == 0) {
                if (get(i+1) == 1) {
                    arr[i] = 2;
                }
                else {
                    arr[i] = 1;
                }
            }
            else if (get(i-1) == 1) {
                if (get(i+1) == 2) {
                    arr[i] = 3;
                }
                else {
                    arr[i] = 2;
                }
            }
            else if (get(i-1) == 2) {
                if (get(i+1) == 1) {
                    arr[i] = 3;
                }
                else {
                    arr[i] = 1;
                }
            }
            else if (get(i-1) == 3) {
                if (get(i+1) == 1) {
                    arr[i] = 2;
                }
                else {
                    arr[i] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            sb.append(arr[i]).append(i < N-1 ? ' ' : '\n');
        }
        System.out.print(sb);
    }

    private static int get(int i) {
        if (i < 0 || i >= N) {
            return 0;
        }
        return arr[i];
    }

}
