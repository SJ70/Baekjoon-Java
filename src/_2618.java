import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2618 {

    private static int N;
    private static int W;
    private static int[][] spots;
    private static Node[][] dp;

    private static class Node {
        int prevI, prevJ, dist;

        public Node(int prevI, int prevJ, int dist) {
            this.prevI = prevI; // 이전에 경찰차 1이 있던 곳
            this.prevJ = prevJ; // 이전에 경찰차 2가 있던 곳
            this.dist = dist;
        }
    }

    private static int[][] startSpots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        startSpots = new int[][] {{1, 1}, {N, N}};

        spots = new int[W + 1][2];
        for (int i=1; i<=W; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            spots[i][0] = Integer.parseInt(st.nextToken());
            spots[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new Node[W + 1][W + 1];
        dp[1][0] = new Node(0, 0, getDist(startSpots[0], spots[1]));
        dp[0][1] = new Node(0, 0, getDist(startSpots[1], spots[1]));

        for (int next = 1; next <= W; next++) {
            for (int prevI = 0; prevI < next; prevI++) {

                int from = (prevI == next - 1) ? 0 : next - 1;
                for (int prevJ = from; prevJ < next; prevJ++) {
                    if (prevI == prevJ) {
                        continue;
                    }

                    // 1이 움직임, prevI -> next
                    int dist1 = dp[prevI][prevJ].dist + getDist((prevI == 0 ? startSpots[0] : spots[prevI]), spots[next]);
                    if (dp[next][prevJ] == null || dp[next][prevJ].dist > dist1) {
                        dp[next][prevJ] = new Node(prevI, prevJ, dist1);
                    }

                    // 2이 움직임, prevJ -> next
                    int dist2 = dp[prevI][prevJ].dist + getDist((prevJ == 0 ? startSpots[1] : spots[prevJ]), spots[next]);
                    if (dp[prevI][next] == null || dp[prevI][next].dist > dist2) {
                        dp[prevI][next] = new Node(prevI, prevJ, dist2);
                    }

                }
            }
        }

//        for (int i=0; i<=W; i++) {
//            for (int j=0; j<=W; j++) {
//                System.out.printf("%5d", dp[i][j] == null ? -1 : dp[i][j].dist);
//            }
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println();

        int minResult = Integer.MAX_VALUE;
        int resultI = -1;
        int resultJ = -1;
        for (int i=0; i<W; i++) {
            if (minResult > dp[i][W].dist) {
                minResult = dp[i][W].dist;
                resultI = i;
                resultJ = W;
            }
        }
        for (int j=0; j<W; j++) {
            if (minResult > dp[W][j].dist) {
                minResult = dp[W][j].dist;
                resultI = W;
                resultJ = j;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            if (resultI == 0 && resultJ == 0) {
                break;
            }
//            System.out.printf("(%d, %d) from (%d, %d), dist: %d\n",  resultI, resultJ, dp[resultI][resultJ].prevI, dp[resultI][resultJ].prevJ, dp[resultI][resultJ].dist);
            Node node = dp[resultI][resultJ];

            sb.append('\n');
            sb.append((resultI != node.prevI) ? 1 : 2);

            resultI = node.prevI;
            resultJ = node.prevJ;
        }

        System.out.println(minResult);
        System.out.print(sb.reverse());
    }

    private static int getDist(int[] spot1, int[] spot2) {
        return Math.abs(spot1[0] - spot2[0]) + Math.abs(spot1[1] - spot2[1]);
    }

}
