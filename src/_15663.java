import java.io.*;
import java.util.*;

public class _15663 {

    private static int n;
    private static int m;
    private static List<Integer> numbers = new ArrayList<>();

    private static boolean[] visited;

    private static int[] result;
    private static Set<String> results = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        input();
        sort();
        solve();
        print();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers.add(number);
        }

        result = new int[m];
        visited = new boolean[n];
    }

    private static void sort() {
        Collections.sort(numbers);
    }

    private static void solve() {
        bt(0);
    }

    private static void bt(int depth) {
        if (depth == m) {
            addResult();
            return;
        }
        for (int i=0; i<n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result[depth] =  numbers.get(i);
            bt(depth + 1);
            visited[i] = false;
        }
    }

    private static void addResult() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++) {
            sb.append(result[i]);
            sb.append((i == m - 1) ? '\n' : ' ');
        }
        results.add(sb.toString());
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (String result : results) {
            sb.append(result);
        }
        System.out.print(sb);
    }
}
