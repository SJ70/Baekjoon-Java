import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14248 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int startIdx = Integer.parseInt(br.readLine()) - 1;

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        q.add(startIdx);
        visited[startIdx] = true;

        while (!q.isEmpty()) {
            int idx = q.poll();
            int value = arr[idx];
            int leftIdx = idx - value;
            if (leftIdx >= 0 && !visited[leftIdx]) {
                q.add(leftIdx);
                visited[leftIdx] = true;
            }
            int rightIdx = idx + value;
            if (rightIdx < N && !visited[rightIdx]) {
                q.add(rightIdx);
                visited[rightIdx] = true;
            }
        }

        int result = 0;
        for (boolean b : visited) {
            if (b) {
                result++;
            }
        }
        System.out.println(result);
    }

}
