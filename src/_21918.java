import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _21918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            switch (a) {
                case 1 :
                    arr[b-1] = c;
                    break;
                case 2 :
                    for (int i=b-1; i<=c-1; i++) {
                        arr[i] = (arr[i] + 1) % 2;
                    }
                    break;
                case 3 :
                    for (int i=b-1; i<=c-1; i++) {
                        arr[i] = 0;
                    }
                    break;
                case 4 :
                    for (int i=b-1; i<=c-1; i++) {
                        arr[i] = 1;
                    }
                    break;
            }
        }

        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

}
