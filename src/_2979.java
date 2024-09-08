import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2979 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];
        for (int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int until = Integer.parseInt(st.nextToken());
            for (int j=from; j<until; j++) {
                arr[j]++;
            }
        }

        int result = 0;
        for (int i=0; i<=100; i++) {
            switch (arr[i]) {
                case 1 : result += A; break;
                case 2 : result += B * 2; break;
                case 3 : result += C * 3; break;
            }
        }
        System.out.println(result);
    }

}
