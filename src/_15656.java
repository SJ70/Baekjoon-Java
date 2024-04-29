import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15656 {

    private static int N, M;
    private static int[] nums;
    private static boolean[] usedNums;
    private static int[] selectedNums;
    private static StringBuilder results = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        dfs(0);
        System.out.print(results);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        usedNums = new boolean[N];
        selectedNums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i=0; i<M; i++) {
                results.append(selectedNums[i]);
                results.append(i == M-1 ? '\n' : ' ');
            }
            return;
        }
        for (int i=0; i<N; i++) {
            selectedNums[depth] = nums[i];
            usedNums[i] = true;
            dfs(depth + 1);
            usedNums[i] = false;
        }
    }

}
