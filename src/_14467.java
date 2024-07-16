import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _14467 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        Map<Integer, Integer> cowPos = new HashMap<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (cowPos.containsKey(cow)) {
                if (cowPos.get(cow) != value) {
                    result++;
                    cowPos.put(cow, value);
                }
            }
            else {
                cowPos.put(cow, value);
            }
        }
        System.out.println(result);

    }

}
