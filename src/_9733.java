import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _9733 {

    private static final String[] WORKS = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> works = new HashMap<>();

        int worksCnt = 0;
        String input = null;
        while ((input = br.readLine()) != null) {
            for (String work : input.split(" ")) {
                works.put(work, works.getOrDefault(work, 0) + 1);
                worksCnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String work : WORKS) {
            int cnt = works.getOrDefault(work, 0);
            double percent = (double) cnt / worksCnt;
            sb.append(String.format("%s %d %.2f\n", work, cnt, percent));
        }
        sb.append(String.format("Total %d 1.00", worksCnt));
        System.out.println(sb);

    }

}
