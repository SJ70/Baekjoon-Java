import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9626 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int up = Integer.parseInt(st.nextToken());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        char[][] chars = new char[R][C];
        for (int r=0; r<R; r++) {
            chars[r] = br.readLine().toCharArray();
        }

        StringBuilder result = new StringBuilder();
        for (int r = 0; r < R + up + down; r++) {
            for (int c = 0; c < C + left + right; c++) {
                if (r >= up && r < up + R && c >= left && c < left + C) {
                    result.append(chars[r - up][c - left]);
                }
                else {
                    result.append((r + c) % 2 == 0 ? '#' : '.');
                }
            }
            result.append('\n');
        }

        System.out.print(result);
    }

}
