import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _4191 {

    private static int N, M, L;
    private static boolean[] fallen;
    private static List<Integer>[] arr;
    private static int fallenCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            fallen = new boolean[N];
            arr = new List[N];
            fallenCnt = 0;

            for (int i=0; i<N; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int m=0; m<M; m++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                arr[from].add(to);
            }
            for (int l=0; l<L; l++) {
                int idx = Integer.parseInt(br.readLine()) - 1;
                if (!fallen[idx]) {
                    fall(idx);
                }
            }
            sb.append(fallenCnt);
            sb.append('\n');
        }
        System.out.print(sb);

    }

    private static void fall(int idx) {
        fallenCnt++;
        fallen[idx] = true;
        for (int i : arr[idx]) {
            if (!fallen[i]) {
                fall(i);
            }
        }
    }

}
