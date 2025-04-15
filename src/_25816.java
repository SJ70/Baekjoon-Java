import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _25816 {

    private static class Team {
        String name;
        int sum;
        int cnt;
        double avg;

        public Team(String name) {
            this.name = name;
        }

        public void add(int rank) {
            sum += rank;
            cnt++;
        }

        public void calcAvg() {
            this.avg = (double) sum / cnt;
        }
    }

    private static Map<String, Team> map = new HashMap<>();
    private static List<Team> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=1; i<=n; i++) {
            String teamName = br.readLine();
            if (!map.containsKey(teamName)) {
                map.put(teamName, new Team(teamName));
            }
            Team team = map.get(teamName);
            team.add(i);
        }
        map.forEach((s, team) -> list.add(team));
        list.forEach(Team::calcAvg);
        list.sort((a, b) -> - Double.compare(b.avg, a.avg));
        System.out.println(list.stream().map(t -> t.name).collect(Collectors.joining("\n")));
    }

}
