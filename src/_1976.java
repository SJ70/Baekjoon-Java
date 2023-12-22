import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1976 {

    private static int cityCnt;
    private static boolean[][] connected;
    private static int planCityCnt;
    private static int[] planCities;

    public static void main(String[] args) throws IOException {
        init();
        fw();
        System.out.println(canDoPlan() ? "YES" : "NO");
//        for (int i = 0; i < cityCnt; i++) {
//            for (int j = 0; j < cityCnt; j++) {
//                System.out.print(connected[i][j] ? 1 : 0);
//            }
//            System.out.println();
//        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cityCnt = Integer.parseInt(br.readLine());
        planCityCnt = Integer.parseInt(br.readLine());

        connected = new boolean[cityCnt][cityCnt];
        for (int i = 0; i < cityCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cityCnt; j++) {
                connected[i][j] = st.nextToken().equals("1");
            }
        }

        planCities = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(value -> value - 1)
                .toArray();
    }

    private static void fw() {
        for (int across = 0; across < cityCnt; across++) {
            for (int from = 0; from < cityCnt; from++) {
                if (from == across || !connected[from][across]) {
                    continue;
                }
                for (int to = 0; to < cityCnt; to++) {
                    if (to == across || to == from || connected[from][to] || !connected[across][to]) {
                        continue;
                    }
                    connected[from][to] = true;
                }
            }
        }
        for (int i = 0; i < cityCnt; i++) {
            connected[i][i] = true;
        }
    }

    private static boolean canDoPlan() {
        int from = planCities[0];
        for (int i = 1; i < planCityCnt; i++) {
            int to = planCities[i];
            if (!connected[from][to]) {
                return false;
            }
            from = to;
        }
        return true;
    }

}
