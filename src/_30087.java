import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _30087 {
    public static void main(String[] args) throws IOException {

        Map<String, String> rooms = new HashMap<>();
        rooms.put("Algorithm", "204");
        rooms.put("DataAnalysis", "207");
        rooms.put("ArtificialIntelligence", "302");
        rooms.put("CyberSecurity", "B101");
        rooms.put("Network", "303");
        rooms.put("Startup", "501");
        rooms.put("TestStrategy", "105");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            sb.append(rooms.get(br.readLine())).append('\n');
        }

        System.out.print(sb);
    }
}
