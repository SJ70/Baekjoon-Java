import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class _1079 {

    private static final int ALIVE = 0;
    private static final int KILLED = 1;
    private static final int VOTED = 2;
    // ex) 0120 : 2번이 밤에 죽고 3번이 낮에 죽은 상태

    private static int[] deathState;

    private static int n;
    private static int playerNum;

    private static int[] guiltyPoints;
    private static int[][] guiltyPointsEachOther;

    private static Set<String> happenedDeathState = new HashSet<>();

    private static int result = 0;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 0);
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        deathState = new int[n];

        guiltyPoints = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        guiltyPointsEachOther = new int[n][n];
        for (int r=0; r<n; r++) {
            guiltyPointsEachOther[r] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        playerNum = Integer.parseInt(br.readLine());
    }

    private static final int NIGHT = 0;
    private static final int DAY = 1;
    private static void dfs(int turn, int day) {

//        System.out.println(
//                " ".repeat(turn * 2) + day + " : "
//                        + Arrays.stream(deathState).mapToObj(String::valueOf).collect(Collectors.joining(",")) + " , "
//                        + Arrays.stream(guiltyPoints).mapToObj(String::valueOf).collect(Collectors.joining(","))
//        );

        if (deathState[playerNum] != ALIVE || turn == n + 1) {
            result = Math.max(result, day);
            return;
        }

        int type = (n - turn) % 2;

        if (type == NIGHT) {
            for (int i=0; i<n; i++) {
                if (deathState[i] != ALIVE) {
                    continue;
                }
                kill(i);
                String deathStateString = deathStateToString();
                if (!happenedDeathState.contains(deathStateString)) {
                    happenedDeathState.add(deathStateString);
                    dfs(turn + 1, day + 1);
                }
                unKill(i);
            }
        }
        if (type == DAY) {
            int votedNum = getVotedNum();
            deathState[votedNum] = VOTED;
            dfs(turn + 1, day);
            deathState[votedNum] = ALIVE;
        }
    }

    private static String deathStateToString() {
        StringBuilder sb = new StringBuilder();
        for (int num : deathState) {
            sb.append(num);
        }
        return sb.toString();
    }

    private static void kill(int i) {
        deathState[i] = KILLED;
        for (int j=0; j<n; j++) {
            guiltyPoints[j] += guiltyPointsEachOther[i][j];
        }
    }

    private static void unKill(int i) {
        deathState[i] = ALIVE;
        for (int j=0; j<n; j++) {
            guiltyPoints[j] -= guiltyPointsEachOther[i][j];
        }
    }

    private static int getVotedNum() {
        int result = 0;
        int value = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            if (deathState[i] != ALIVE) {
                continue;
            }
            if (value < guiltyPoints[i]) {
                result = i;
                value = guiltyPoints[i];
            }
        }
        return result;
    }

}
