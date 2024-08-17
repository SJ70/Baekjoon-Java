import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class _23349 {

    public static void main(String[] args) throws IOException {

        Map<String, Integer>[] timeTable = new Map[50001];
        for (int i=0; i<=50000; i++) {
            timeTable[i] = new HashMap<>();
        }
        Set<String> students = new HashSet<>();

        int maxCnt = 0;
        String maxResult = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (students.contains(name)) {
                continue;
            }
            else {
                students.add(name);
            }
            String place = st.nextToken();
            int timeStart = Integer.parseInt(st.nextToken());
            int timeEnd = Integer.parseInt(st.nextToken());
            for (int time = timeStart; time < timeEnd; time++) {
                int cnt = timeTable[time].getOrDefault(place, 0) + 1;
                timeTable[time].put(place, cnt);
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    maxResult = place;
                }
                if (cnt == maxCnt) {
                    maxResult = maxResult.compareTo(place) < 0 ? maxResult : place;
                }
            }
        }

//        for (int i=0; i<=10; i++) {
//            System.out.println(timeTable[i]);
//        }
        int resultFrom = -1;
        int resultEnd = -1;
        for (int i=1; i<=50000; i++) {
            if (timeTable[i].getOrDefault(maxResult, 0) == maxCnt) {
                resultFrom = i;
                i++;
                while (timeTable[i].getOrDefault(maxResult, 0) == maxCnt) {
                    i++;
                }
                resultEnd = i - 1;
                break;
            }
        }
        System.out.printf("%s %d %d", maxResult, resultFrom, resultEnd + 1);

    }

}
