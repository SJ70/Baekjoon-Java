import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493 {

    private static int n;
    private static Stack<Tower> towers = new Stack<>();
    private static int[] result;

    private static class Tower {
        int position;
        int height;

        public Tower(int p, int h) {
            position = p;
            height = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        result = new int[n + 1];
        towers.push(new Tower(0, 100000000));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int pos=1; pos<=n; pos++) {
            int height = Integer.parseInt(st.nextToken());
            while (!towers.isEmpty() && towers.peek().height < height) {
                    towers.pop();
            }
            result[pos] = towers.peek().position;

            towers.push(new Tower(pos, height));
        }

        StringBuilder sb = new StringBuilder();
        for (int pos=1; pos<=n; pos++) {
            sb.append(result[pos]);
            sb.append(pos==n ? '\n' : ' ');
        }

        System.out.print(sb);
    }

}
