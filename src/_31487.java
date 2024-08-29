import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class _31487 {

    private static class TeamScore {
        String name;
        int score;
        int idx;

        public TeamScore(String name, int idx, int score) {
            this.name = name;
            this.idx = idx;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<TeamScore> pq = new PriorityQueue<>((a, b) -> (b.score != a.score) ? b.score - a.score : a.idx - b.idx);

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int winCnt = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> scores = new PriorityQueue<>();
            for (int j=0; j<6; j++) {
                scores.add(Integer.parseInt(st.nextToken()));
            }
            int score = winCnt * 10;
            scores.poll();
            for (int j=0; j<4; j++) {
                score += scores.poll();
            }
            pq.add(new TeamScore(name, i, score));
        }

        Set<Integer> scoreKind = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int prevScore = -1;
        for (int i=0; i<1000 && !pq.isEmpty(); i++) {
            TeamScore teamScore = pq.poll();
            if (prevScore != teamScore.score) {
                if (i >= 3) {
                    break;
                }
            }
            prevScore = teamScore.score;
            scoreKind.add(teamScore.score);
            if (scoreKind.size() > 3) {
                break;
            }
            sb.append(String.format("%s %d\n", teamScore.name, teamScore.score));
        }
        System.out.print(sb);

    }

}
