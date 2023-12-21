import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _18428 {

    private enum State {
        TEACHER("T"), STUDENT("S"), WALL("O"), NOTHING("X");

        private final String value;

        State(String value) {
            this.value = value;
        }

        public static State getState(String value) {
            return Arrays.stream(values())
                    .filter(state -> state.value.equals(value))
                    .findFirst()
                    .get();
        }
    }

    private static class Coordinate {
        int r, c;

        public Coordinate (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int N;
    private static State[][] states;
    private static List<Coordinate> teachers = new ArrayList<>();
    private static List<Coordinate> worthyPlaces = new ArrayList<>();
    private static boolean foundAnyResultToTeachersCanNotSeeStudents;

    public static void main(String[] args) throws IOException {
        init();
        setWorthyWhichCanTeachersSeeStudentsThrough();
        checkCanTeachersSeeStudents();
        dfs(0, 0);
        System.out.println(foundAnyResultToTeachersCanNotSeeStudents ? "YES" : "NO");
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        states = new State[N][N];
        for (int r=0; r<N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++) {
                states[r][c] = State.getState(st.nextToken());
                if (states[r][c] == State.TEACHER) {
                    teachers.add(new Coordinate(r, c));
                }
            }
        }
    }

    private static void setWorthyWhichCanTeachersSeeStudentsThrough() {
        Queue<Coordinate> coordinates = new ArrayDeque<>();
        for (Coordinate teacher : teachers) {
            for (int dir = 0; dir < 4; dir++) {
                int r = teacher.r;
                int c = teacher.c;
                while (true) {
                    r += dr[dir];
                    c += dc[dir];
                    if (isOutOfRange(r, c)) {
                        coordinates.clear();
                        break;
                    }
                    if (states[r][c] == State.STUDENT) {
                        worthyPlaces.addAll(coordinates);
                        break;
                    }
                    if (states[r][c] == State.TEACHER) {
                        coordinates.clear();
                        break;
                    }
                    coordinates.add(new Coordinate(r, c));
                }
            }
        }
    }

    private static void printStates() {
        System.out.println(Arrays.stream(states)
                .map(arr -> Arrays.stream(arr)
                        .map(state -> state.value)
                        .collect(Collectors.toList())
                        .toString())
                .collect(Collectors.joining("\n")));
    }

    private static void dfs(int index, int wallCnt) {
        if (foundAnyResultToTeachersCanNotSeeStudents) {
            return;
        }
        if (wallCnt == 3 || wallCnt == worthyPlaces.size()) {
            checkCanTeachersSeeStudents();
            return;
        }
        if (index >= worthyPlaces.size()) {
            return;
        }

        int r = worthyPlaces.get(index).r;
        int c = worthyPlaces.get(index).c;

        states[r][c] = State.WALL;
        dfs(index + 1, wallCnt + 1);
        states[r][c] = State.NOTHING;
        dfs(index + 1, wallCnt);
    }

    private static void checkCanTeachersSeeStudents() {
        for (Coordinate teacher : teachers) {
            if (canTeacherSeeStudent(teacher)) {
                return;
            }
        }
//        printStates();
        foundAnyResultToTeachersCanNotSeeStudents = true;
    }

    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};

    private static boolean canTeacherSeeStudent(Coordinate teacher) {
        for (int dir = 0; dir < 4; dir++) {
            int r = teacher.r;
            int c = teacher.c;
            while (true) {
                r += dr[dir];
                c += dc[dir];
                if (isOutOfRange(r, c)) {
                    break;
                }
                if (states[r][c] == State.STUDENT) {
                    return true;
                }
                if (states[r][c] == State.WALL || states[r][c] == State.TEACHER) {
                    break;
                }
            }
        }
        return false;
    }

    private static boolean isOutOfRange(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= N;
    }

}
