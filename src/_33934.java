import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _33934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        st = new StringTokenizer(br.readLine());
        int[] rock = new int[N];
        for (int i=0; i<N; i++) {
            rock[i] = Integer.parseInt(st.nextToken());
        }

        int limit = Integer.parseInt(br.readLine());

        int minDist = end - start + 1;

        int maxDist = 0;
        int left = start;
        while (left > 0) {
            if (rock[left] == 1) {
                break;
            }
            left--;
        }
        int right = end;
        while (right < N - 1) {
            if (rock[right] == 1) {
                break;
            }
            right++;
        }
        for (int i=left; i<=right; i++) {
            maxDist += rock[i];
        }

        if (maxDist >= limit && minDist <= limit) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

}
