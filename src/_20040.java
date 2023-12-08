import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class _20040 {

    private static int[] unionFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        unionFind = IntStream.range(0, E).toArray();

        int V = Integer.parseInt(st.nextToken());
        for (int i=1; i<=V; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int a = Math.max(num1, num2);
            int b = Math.min(num1, num2);
            if (isConnected(a, b)) {
                System.out.println(i);
                return;
            }
            connect(a, b);
        }
        System.out.println(0);
    }

    private static boolean isConnected(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    private static void connect(int a, int b) {
        unionFind[getRoot(a)] = getRoot(b);
    }

    private static int getRoot(int a) {
        int parent = unionFind[a];
        if (parent == a) {
            return parent;
        }
        unionFind[a] = getRoot(parent);
        return unionFind[a];
    }

}
