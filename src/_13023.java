import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _13023 {

    private static int peopleCnt;
    private static int relationshipCnt;
    private static List<Integer>[] relationship;

    private static boolean visited[];
    private static boolean foundResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        peopleCnt = Integer.parseInt(st.nextToken());
        relationshipCnt = Integer.parseInt(st.nextToken());

        relationship = new List[peopleCnt];
        for (int i=0; i<peopleCnt; i++) {
            relationship[i] = new ArrayList<>();
        }

        for (int i=0; i<peopleCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relationship[a].add(b);
            relationship[b].add(a);
        }

        visited = new boolean[peopleCnt];

        for (int i=0; i<relationshipCnt; i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
        }

        System.out.println(foundResult ? 1 : 0);
    }

    private static void dfs(int idx, int depth) {
        if (depth == 5) {
            foundResult = true;
        }
        if (foundResult) {
            return;
        }
        for (int friend : relationship[idx]) {
            if (visited[friend]) {
                continue;
            }
            visited[friend] = true;
            dfs(friend, depth + 1);
            visited[friend] = false;
        }
    }

}
