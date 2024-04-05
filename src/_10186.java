import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10186 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean[][] tiles = new boolean[4][14];

            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                char c = str.charAt(0);
                int value = Integer.parseInt(str.substring(1));
                tiles[c - 'A'][value] = true;
            }

            int maxValue = 0;
            StringBuilder resultTiles = new StringBuilder();

            // 연속
            for (int c=0; c<4; c++) {
                int value = 0;
                int cnt = 0;
                StringBuilder selectedTiles = new StringBuilder();

                for (int v=1; v<=13; v++) {
                    if (tiles[c][v]) {
                        value += v;
                        cnt++;
                        selectedTiles.append((char)(c+'A')).append(v).append(' ');

                        if (value > maxValue && cnt >= 3) {
                            maxValue = value;
                            resultTiles = selectedTiles;
                        }
                    }
                    else {
                        value = 0;
                        cnt = 0;
                        selectedTiles = new StringBuilder();
                    }
                }
            }

            // 동일
            for (int v=1; v<=13; v++) {
                int cnt = 0;
                StringBuilder selectedTiles = new StringBuilder();

                for (int c=0; c<4; c++) {
                    if (tiles[c][v]) {
                        cnt++;
                        selectedTiles.append((char)(c+'A')).append(v).append(' ');
                    }
                }

                if (cnt >= 3) {
                    if (v * cnt > maxValue) {
                        maxValue = v * cnt;
                        resultTiles = selectedTiles;
                    }
                }
            }

            sb.append(maxValue == 0 ? "NO GROUPS OR RUNS" : (resultTiles.toString() + maxValue));
            sb.append('\n');
        }

        System.out.print(sb);

    }

}
