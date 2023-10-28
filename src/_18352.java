import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _18352 {

    private static int cityCount;
    private static int rootCount;
    private static int targetDistance;
    private static int startCityNumber;

    private static List<Integer>[] roots;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        cityCount = Integer.parseInt(st.nextToken());
        rootCount = Integer.parseInt(st.nextToken());
        targetDistance = Integer.parseInt(st.nextToken());
        startCityNumber = Integer.parseInt(st.nextToken());

        roots = new List[cityCount + 1];
        for (int i = 1; i <= cityCount; i++) {
            roots[i] = new ArrayList<>();
        }

        for (int i = 0; i < rootCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            roots[from].add(to);
        }
    }

    private static String bfs() {
        boolean[] visited = new boolean[cityCount + 1];
        Queue<Integer> q = new ArrayDeque<>();

        q.add(startCityNumber);
        visited[startCityNumber] = true;

        for (int i = 0; i < targetDistance; i++) {
            int qSize = q.size();
            for (int j = 0; j < qSize; j++) {
                int cityNumber = q.poll();
                for (int nextCityNumber : roots[cityNumber]) {
                    if (!visited[nextCityNumber]) {
                        q.add(nextCityNumber);
                        visited[nextCityNumber] = true;
                    }
                }
            }
        }

        String result = q.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));

        if (result.equals("")) {
            return "-1";
        }
        return result;
    }

}
