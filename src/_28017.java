import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _28017 {

    private static int gameCnt;
    private static int weaponCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        gameCnt = Integer.parseInt(st.nextToken());
        weaponCnt = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> prevPq = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));
        PriorityQueue<int[]> curPq;

        prevPq.add(new int[] {0, 0});
        prevPq.add(new int[] {0, 1});

        for (int i=0; i<gameCnt; i++) {
            int[] currentGameWeaponValue = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int[] minValue = prevPq.poll();
            int[] secondMinValue = prevPq.poll();
            curPq = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));
            for (int j=0; j<weaponCnt; j++) {
                int value = (j != minValue[1] ? minValue[0] : secondMinValue[0]) + currentGameWeaponValue[j];
                curPq.add(new int[] {value, j});
            }
            prevPq = curPq;
        }
        System.out.println(prevPq.poll()[0]);
    }

}
