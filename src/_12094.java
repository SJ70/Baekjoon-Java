import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12094 {

    private static int N;
    private static int max;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        byte[][] arr = new byte[N][N];
        for (int r=0; r<N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++) {
                // 실제 값 대신 2의 몇 승인지 저장, 2^n -> n
                // 이러면 byte로도 저장이 가능함
                int value = Integer.parseInt(st.nextToken());
                while (value > 1) {
                    arr[r][c]++;
                    value /= 2;
                }
                max = Math.max(max, arr[r][c]);
            }
        }

        dfs(arr, 1);

        System.out.println((int) Math.pow(2, max));
    }

    private static void dfs(byte[][] arr, int i) {
        if (i > 10) {
            return;
        }
        i++;
        dfs(moveUp(arr), i);
        dfs(moveDown(arr), i);
        dfs(moveLeft(arr), i);
        dfs(moveRight(arr), i);
    }

    private static byte[][] moveUp(byte[][] cur) {
        byte[][] next = new byte[N][N];
        for (int c=0; c<N; c++) {
            int nextR = 0;
            for (int r=0; r<N; r++) {
                if (cur[r][c] == 0) {
                    continue;
                }
                if (next[nextR][c] == cur[r][c]) {
                    // 같은 값은 압축 후 다음 인덱스
                    next[nextR][c]++;
                    max = Math.max(next[nextR][c], max);
                    nextR++;
                }
                else {
                    // 다른 값은 다음 인덱스
                    if (next[nextR][c] != 0) {
                        // 0이면 해당 칸에, 아니면 다음 칸에
                        nextR++;
                    }
                    next[nextR][c] = cur[r][c];
                }
            }
        }
        return next;
    }

    private static byte[][] moveDown(byte[][] cur) {
        byte[][] next = new byte[N][N];
        for (int c=0; c<N; c++) {
            int nextR = N-1;
            for (int r=N-1; r>=0; r--) {
                if (cur[r][c] == 0) {
                    continue;
                }
                if (next[nextR][c] == cur[r][c]) {
                    next[nextR][c]++;
                    max = Math.max(next[nextR][c], max);
                    nextR--;
                }
                else {
                    if (next[nextR][c] != 0) {
                        nextR--;
                    }
                    next[nextR][c] = cur[r][c];
                }
            }
        }
        return next;
    }

    private static byte[][] moveLeft(byte[][] cur) {
        byte[][] next = new byte[N][N];
        for (int r=0; r<N; r++) {
            int nextC = 0;
            for (int c=0; c<N; c++) {
                if (cur[r][c] == 0) {
                    continue;
                }
                if (next[r][nextC] == cur[r][c]) {
                    next[r][nextC]++;
                    max = Math.max(next[r][nextC], max);
                    nextC++;
                }
                else {
                    if (next[r][nextC] != 0) {
                        nextC++;
                    }
                    next[r][nextC] = cur[r][c];
                }
            }
        }
        return next;
    }

    private static byte[][] moveRight(byte[][] cur) {
        byte[][] next = new byte[N][N];
        for (int r=0; r<N; r++) {
            int nextC = N-1;
            for (int c=N-1; c>=0; c--) {
                if (cur[r][c] == 0) {
                    continue;
                }
                if (next[r][nextC] == cur[r][c]) {
                    next[r][nextC]++;
                    max = Math.max(next[r][nextC], max);
                    nextC--;
                }
                else {
                    if (next[r][nextC] != 0) {
                        nextC--;
                    }
                    next[r][nextC] = cur[r][c];
                }
            }
        }
        return next;
    }

    private static void printArr(byte[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                sb.append(String.format("%3d", arr[r][c]));
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
