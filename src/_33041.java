import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _33041 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] numCnt = new int[N];
        int[] sum = new int[N];
        for (int i=0; i<N; i++) {
            numCnt[i] = sum[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int one = Integer.parseInt(st.nextToken());
        int nine = Integer.parseInt(st.nextToken());

        int[] nineCnt = new int[N];
        // 9를 필요한 만큼만 소비
        // 위에서부터 최대한 적게
        for (int i=1; i<N; i++) {
            while (sum[i-1] >= sum[i]) {    // can be faster
                sum[i] += 8;
                nineCnt[i]++;
                nine--;
                if (nineCnt[i] > numCnt[i] || nine < 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        // 남은 9를 소비
        // 아래부터 최대한 많이
        for (int i=N-1; i>=0; i--) {
            if (nine == 0) {
                break;
            }
            while (nineCnt[i] < numCnt[i] && nine > 0 && (i==N-1 || sum[i+1] > sum[i] + 8)) {
                nineCnt[i]++;
                sum[i] += 8;
                nine--;
            }
        }

        if (nine > 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            int n = nineCnt[i];
            int o = numCnt[i] - nineCnt[i];
            for (int j=0; j<numCnt[i]; j++) {
                sb.append(j < n ? 9 : 1);
                sb.append(j == numCnt[i]-1 ? '\n' : ' ');
            }
        }
        System.out.print(sb);

    }

}
