import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _3041 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> map = new HashMap<>();
        for (char i='A'; i<='O'; i++) {
            int idx = i - 'A';
            map.put(i, idx);
        }

        int result = 0;
        for (int r=0; r<4; r++) {
            String str = br.readLine();
            for (int c=0; c<4; c++) {
                char value = str.charAt(c);
                if (value == '.') {
                    continue;
                }
                int idx = map.get(value);
                int r0 = idx / 4;
                int c0 = idx % 4;
                result += Math.abs(r - r0) + Math.abs(c - c0);
            }
        }

        System.out.println(result);
    }

}
