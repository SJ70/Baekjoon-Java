import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _1717 {

    private static int[] unionFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int edgeCount = Integer.parseInt(st.nextToken());
        int commandCount = Integer.parseInt(st.nextToken());
        unionFind = IntStream.rangeClosed(0, edgeCount).toArray();

        for (int i=0; i<commandCount; i++) {
            StringTokenizer command = new StringTokenizer(br.readLine());
            int commandType = Integer.parseInt(command.nextToken());
            int a = Integer.parseInt(command.nextToken());
            int b = Integer.parseInt(command.nextToken());
            int num1 = Math.max(a, b);
            int num2 = Math.min(a, b);
            if (commandType == 0) {
                connect(num1, num2);
            }
            if (commandType == 1) {
                sb.append(isConnected(num1, num2) ? "YES\n" : "NO\n");
            }
//            System.out.println(Arrays.stream(unionFind).mapToObj(Integer::valueOf).collect(Collectors.toList()));
        }
        System.out.print(sb);
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
            return a;
        }
        unionFind[a] = getRoot(parent);
        return unionFind[a];
    }
}
