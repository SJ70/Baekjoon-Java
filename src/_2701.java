import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class _2701 {

    private static final String[][][][][][][] move = new String[7][7][7][7][7][7][7];
    private static final Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        // 6 : 중앙
        move[0][1][2][3][4][5][6] = "";
        q.add(new int[]{0, 1, 2, 3, 4, 5, 6});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            String curMove = move[cur[0]][cur[1]][cur[2]][cur[3]][cur[4]][cur[5]][cur[6]];
            if (cur[6] == 6) {
                visit(cur, 0, 6, 2, 3, 4, 5, 1, 1, curMove);
                visit(cur, 0, 1, 2, 3, 6, 5, 4, 4, curMove);
            }
            else if (cur[0] == 6) {
                visit(cur, 5, 1, 2, 3, 4, 0, 6, 5, curMove);
                visit(cur, 1, 0, 2, 3, 4, 5, 6, 1, curMove);
            }
            else if (cur[1] == 6) {
                visit(cur, 1, 0, 2, 3, 4, 5, 6, 0, curMove);
                visit(cur, 0, 2, 1, 3, 4, 5, 6, 2, curMove);
                visit(cur, 0, 6, 2, 3, 4, 5, 1, 6, curMove);
            }
            else if (cur[2] == 6) {
                visit(cur, 0, 2, 1, 3, 4, 5, 6, 1, curMove);
                visit(cur, 0, 1, 3, 2, 4, 5, 6, 3, curMove);
            }
            else if (cur[3] == 6) {
                visit(cur, 0, 1, 3, 2, 4, 5, 6, 2, curMove);
                visit(cur, 0, 1, 2, 4, 3, 5, 6, 4, curMove);
            }
            else if (cur[4] == 6) {
                visit(cur, 0, 1, 2, 4, 3, 5, 6, 3, curMove);
                visit(cur, 0, 1, 2, 3, 5, 4, 6, 5, curMove);
                visit(cur, 0, 1, 2, 3, 6, 5, 4, 6, curMove);
            }
            else if (cur[5] == 6) {
                visit(cur, 5, 1, 2, 3, 4, 0, 6, 0, curMove);
                visit(cur, 0, 1, 2, 3, 5, 4, 6, 4, curMove);
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            String str = br.readLine();
            String answer = move[str.charAt(0) - 'A'][str.charAt(1) - 'A'][str.charAt(2) - 'A'][str.charAt(3) - 'A'][str.charAt(4) - 'A'][str.charAt(5) - 'A'][6];
            if (answer == null) {
                sb.append(-1);
            }
            else {
                sb.append(answer.length());
                sb.append(' ');
                sb.append(answer);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void visit(int[] cur, int a, int b, int c, int d, int e, int f, int g, int moveIdx, String origin) {
        if (move[cur[a]][cur[b]][cur[c]][cur[d]][cur[e]][cur[f]][cur[g]] == null) {
            move[cur[a]][cur[b]][cur[c]][cur[d]][cur[e]][cur[f]][cur[g]] = (char)('A' + cur[moveIdx]) + origin;
            q.add(new int[]{cur[a], cur[b], cur[c], cur[d], cur[e], cur[f], cur[g]});
        }
    }

}
