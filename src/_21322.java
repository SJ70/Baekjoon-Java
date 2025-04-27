import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _21322 {

    private static int N, M;

    private static int[][] listIdx; // 해당 좌표의 values 상의 인덱스
    private static List<Integer>[] belts;  // 벨트 당 값
    private static int[] beltsMove;  // 벨트 당 회전 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        listIdx = new int[N][N];
        belts = new List[N/2 + 1];
        beltsMove = new int[N/2 + 1];

        int[][] originalArr = new int[N][N];
        for (int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++) {
                originalArr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=N/2; i++) {
            belts[i] = new ArrayList<>();
        }

        // 소용돌이 모양으로 바깥부터 리스트를 채움
        boolean[][] visited = new boolean[N][N];
        int[] dr = new int[] {0, 1, 0, -1};
        int[] dc = new int[] {1, 0, -1, 0};
        int r = 0;
        int c = 0;
        int dir = 0;
        while (!visited[r][c]) {
//            System.out.printf("%d %d\n", r, c);
            visited[r][c] = true;
            int d = getDepthByPos(r, c);
            listIdx[r][c] = belts[d].size();
            belts[d].add(originalArr[r][c]);

            int nextR = r + dr[dir];
            int nextC = c + dc[dir];
            if (nextR >= N || nextR < 0 || nextC >= N || nextC < 0 || visited[nextR][nextC]) {
                dir++;
                dir%=4;
                r += dr[dir];
                c += dc[dir];
            }
            else {
                r = nextR;
                c = nextC;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int move=0; move<M; move++) {
            st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {

                case 1 :
                    int beltIdx = Integer.parseInt(st.nextToken());
                    int beltMoveValue = Integer.parseInt(st.nextToken());
                    beltsMove[beltIdx] -= beltMoveValue;
                    if (beltsMove[beltIdx] < 0) {
                        beltsMove[beltIdx] = belts[beltIdx].size() + (beltsMove[beltIdx] % belts[beltIdx].size());
                    }
                    break;

                case 2 :
                    int r1 = Integer.parseInt(st.nextToken()) - 1;
                    int c1 = Integer.parseInt(st.nextToken()) - 1;
                    int r2 = r1 + 1;
                    int c2 = c1 + 1;

                    int depth1 = getDepthByPos(r1, c1);
                    int idx1 = (listIdx[r1][c1] + beltsMove[depth1]) % belts[depth1].size();
                    int value1 = belts[depth1].get(idx1);

                    int depth2 = getDepthByPos(r1, c2);
                    int idx2 = (listIdx[r1][c2] + beltsMove[depth2]) % belts[depth2].size();
                    int value2 = belts[depth2].get(idx2);

                    int depth3 = getDepthByPos(r2, c1);
                    int idx3 = (listIdx[r2][c1] + beltsMove[depth3]) % belts[depth3].size();
                    int value3 = belts[depth3].get(idx3);

                    int depth4 = getDepthByPos(r2, c2);
                    int idx4 = (listIdx[r2][c2] + beltsMove[depth4]) % belts[depth4].size();
                    int value4 = belts[depth4].get(idx4);

                    belts[depth1].set(idx1, value3);
                    belts[depth2].set(idx2, value1);
                    belts[depth3].set(idx3, value4);
                    belts[depth4].set(idx4, value2);
                    break;

                case 3 :
                    int r0 = Integer.parseInt(st.nextToken()) - 1;
                    int c0 = Integer.parseInt(st.nextToken()) - 1;
                    int depth = getDepthByPos(r0, c0);
                    int idx = (listIdx[r0][c0] + beltsMove[depth]) % belts[depth].size();
                    int result = belts[depth].get(idx);
                    sb.append(result);
                    sb.append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }

    private static int getDepthByPos(int r, int c) {
        return Math.min(Math.abs(r >= N/2 ? N - r : r + 1), Math.abs(c >= N/2 ? N - c : c + 1));
    }

}