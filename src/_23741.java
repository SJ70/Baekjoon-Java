import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _23741 {

    private static int cupCnt, moveCnt;
    private static List<Integer>[] roots;
    private static Set<Integer> ballPos;

    public static void main(String[] args) throws IOException {
        input();
        for (int i=0; i<moveCnt; i++) {
            moveBall();
        }
        System.out.println(ballPos.isEmpty() ? "-1" : ballPos.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        cupCnt = Integer.parseInt(st.nextToken());
        int rootsCnt = Integer.parseInt(st.nextToken());
        ballPos = new HashSet<>();
        ballPos.add(Integer.parseInt(st.nextToken()));
        moveCnt = Integer.parseInt(st.nextToken());

        roots = new List[cupCnt + 1];
        for (int i=1; i<=cupCnt; i++) {
            roots[i] = new ArrayList<>();
        }
        for (int i=0; i<rootsCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            roots[a].add(b);
            roots[b].add(a);
        }
    }

    private static void moveBall() {
        Set<Integer> nextBallPos = new HashSet<>();
        for (int from : ballPos) {
            nextBallPos.addAll(roots[from]);
        }
        ballPos = nextBallPos;
    }

}
