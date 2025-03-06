import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _26564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            Map<Character, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = 0;
            for (int j=0; j<5; j++) {
                String str = st.nextToken();
                char value = str.charAt(0);
                int cnt = map.getOrDefault(value, 0) + 1;
                result = Math.max(cnt, result);
                map.put(value, cnt);
            }
            System.out.println(result);
        }
    }

}
