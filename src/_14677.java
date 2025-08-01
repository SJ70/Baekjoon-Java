import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class _14677 {

    private static char[] value = {'B', 'L', 'D'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][][] arr = new boolean[3][N*3+2][N*3+2];
        Queue<int[]> q = new ArrayDeque<>();
        String str = ' ' + br.readLine() + ' ';
        arr[0][0][N*3+1] = true;   // 아무것도 안 먹은 시점
        q.add(new int[] {0, 0, N*3+1});
        int result = 0;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int time = pos[0];
            int left = pos[1];
            int right = pos[2];
            result = Math.max(result, time);
            if (left + 1 == right) {
                break;
            }
            if (str.charAt(left+1) == value[time%3] && !arr[time%3][left+1][right]) {
                arr[time%3][left+1][right] = true;
                q.add(new int[] {time+1, left+1, right});
            }
            if (str.charAt(right-1) == value[time%3] && !arr[time%3][left][right-1]) {
                arr[time%3][left][right-1] = true;
                q.add(new int[] {time+1, left, right-1});
            }
        }
        System.out.println(result);
    }

}
