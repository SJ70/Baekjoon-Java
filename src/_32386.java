import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _32386 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int m = Integer.parseInt(st.nextToken());
            for (int j=0; j<m; j++) {
                String tag = st.nextToken();
                map.put(tag, map.getOrDefault(tag, 0) + 1);
            }
        }
        int cnt = 0;
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) > cnt) {
                cnt = map.get(key);
                result = new ArrayList<>();
            }
            if (map.get(key) == cnt) {
                result.add(key);
            }
        }
        System.out.println(result.size() > 1 ? "-1" : result.get(0));
    }

}
