import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _22965 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] sorted = new int[N];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
            sorted[i] = value;
        }
        Arrays.sort(sorted);

        // 정렬된 수의 인덱스
        int[] idx = new int[200001];
        for (int i=0; i<N; i++) {
            idx[sorted[i]] = i;
        }

        // 오른쪽 수가 본인보다 큰 수 중 가장 작은 수가 아니라면 크롭
        int pieceCnt = 1;
        for (int i=0; i<N-1; i++) {
            int cur = arr[i];
            int next = arr[i+1];
            int curIdx = idx[cur];
            if (curIdx == N-1 || next != sorted[curIdx + 1]) {
                pieceCnt++;
            }
        }

        pieceCnt = Math.min(pieceCnt, 3);

        System.out.println(pieceCnt);
    }

}
