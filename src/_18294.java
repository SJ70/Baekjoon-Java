import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _18294 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        for (String name : map.keySet()) {
            int count = map.get(name);
            if (count > N - count) {
                System.out.println(name);
                return;
            }
        }
        System.out.println("NONE");

    }

}
