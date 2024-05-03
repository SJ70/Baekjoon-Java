import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1679 {

    private static final int INF = Integer.MAX_VALUE;
    private static int N, K;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        input();
        int MAX = nums[N-1] * K;
        int[] usedNumberCnt = new int[MAX + 1];
        Arrays.fill(usedNumberCnt, INF);
        usedNumberCnt[0] = 0;

        int i;
        for (i=0; i<=MAX; i++) {
            if (usedNumberCnt[i] == INF) {
                break;
            }
            if (usedNumberCnt[i] == K) {
                continue;
            }
            for (int num : nums) {
                int next = i + num;
                if (next > MAX) {
                    break;
                }
                usedNumberCnt[next] = Math.min(usedNumberCnt[next], usedNumberCnt[i] + 1);
            }
            System.out.printf("#%2d : %s\n", i, Arrays.toString(Arrays.stream(usedNumberCnt).mapToObj(n -> n==INF ? "-" : String.valueOf(n)).toArray()));
        }

        String winner = i%2==0 ? "holsoon" : "jjaksoon";
        System.out.printf("%s win at %d\n", winner, i);

        System.out.println(Arrays.toString(usedNumberCnt));

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(br.readLine());
    }

}
