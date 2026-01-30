import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _27495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] arr = new String[9][9];
        for (int r=0; r<9; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<9; c++) {
                arr[r][c] = st.nextToken();
            }
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                String key = arr[i * 3 + 1][j * 3 + 1];
                List<String> values = Stream.of(
                        arr[i * 3][j * 3],
                        arr[i * 3][j * 3 + 1],
                        arr[i * 3][j * 3 + 2],
                        arr[i * 3 + 1][j * 3],
                        arr[i * 3 + 1][j * 3 + 2],
                        arr[i * 3 + 2][j * 3],
                        arr[i * 3 + 2][j * 3 + 1],
                        arr[i * 3 + 2][j * 3 + 2]
                ).sorted().collect(Collectors.toList());

                map.put(key, values);
            }
        }

        List<String> keys = map.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<8; i++) {
            String key = keys.get(i);
            sb.append(String.format("#%d. %s\n", i+1, key));
            List<String> values = map.get(key);
            for (int j=0; j<8; j++) {
                sb.append(String.format("#%d-%d. %s\n", i+1, j+1, values.get(j)));
            }
        }
        System.out.print(sb);

    }

}
