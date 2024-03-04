import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _28017 {

    private static int gameCnt;
    private static int weaponCnt;
    private static int[][] dpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        gameCnt = Integer.parseInt(st.nextToken());
        weaponCnt = Integer.parseInt(st.nextToken());

        dpArr = new int[gameCnt + 1][weaponCnt];

        for (int i=1; i<=gameCnt; i++) {
            int[] currentGameWeaponValue = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for (int j=0; j<weaponCnt; j++) {
                dpArr[i][j] = getMinValueExcept(dpArr[i - 1], j) + currentGameWeaponValue[j];
            }
        }
        System.out.println(getMinValueExcept(dpArr[gameCnt]));
    }

    private static int getMinValueExcept(int[] arr, int idx) {
        int result = Integer.MAX_VALUE;
        for (int i=0; i<weaponCnt; i++) {
            if (i == idx) {
                continue;
            }
            result = Math.min(arr[i], result);
        }
        return result;
    }

    private static int getMinValueExcept(int[] arr) {
        int result = Integer.MAX_VALUE;
        for (int i=0; i<weaponCnt; i++) {
            result = Math.min(arr[i], result);
        }
        return result;
    }

}
