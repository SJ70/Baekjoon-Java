import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            int cnt = map.getOrDefault(str, 0);
            map.put(str, cnt + 1);
        }

        String maxCntString = "";
        int maxCnt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            int cnt = entry.getValue();
            if (cnt > maxCnt) {
                maxCnt = cnt;
                maxCntString = str;
            }
            if (cnt == maxCnt) {
                maxCntString = str.compareTo(maxCntString) < 0 ? str : maxCntString;
            }
        }

        System.out.println(maxCntString);
    }
}
