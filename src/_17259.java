import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17259 {

    private static int B, N, M;
    private static Queue<int[]> presents;
    private static Worker[][] workers;      // 실제 위치가 아닌 근무자가 작업할 수 있는 위치들에 배치
    private static int result;

    private static class Worker {
        int remainedWorkTime;
        int workingTime;

        public Worker(int workingTime) {
            this.workingTime = workingTime;
        }

        public boolean canWork() {
            return remainedWorkTime == 0;
        }

        public void startWork() {
            remainedWorkTime = workingTime;
        }

        public void doWork() {
            if (remainedWorkTime > 0) {
                remainedWorkTime--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        presents = new ArrayDeque<>();

        workers = new Worker[B][B];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int workingTime = Integer.parseInt(st.nextToken());

            Worker worker = new Worker(workingTime);
            if (r == 1) {
                workers[0][c] = worker;
            }
            if (c == B-2) {
                workers[r][B-1] = worker;
            }
            if (r == B-2) {
                workers[B-1][c] = worker;
            }
        }

        while (M > 0 || !presents.isEmpty()) {
            int qSize = presents.size();
            for (int i=0; i<qSize; i++) {
                int[] present = presents.poll();
                int r = present[0];
                int c = present[1];
                if (workers[r][c] != null && workers[r][c].canWork()) {
                    workers[r][c].startWork();
                    result++;
                }
                else {
                    if (r == B-1) {
                        present[1]--;
                    }
                    else if (c == B-1) {
                        present[0]++;
                    }
                    else if (r == 0) {
                        present[1]++;
                    }
                    if (present[1] >= 0) {
                        presents.add(present);
                    }
                }
            }

            for (int c=0; c<B; c++) {
                if (workers[0][c] != null) {
                    workers[0][c].doWork();
                }
            }
            for (int r=2; r<B-2; r++) {
                if (workers[r][B-1] != null) {
                    workers[r][B-1].doWork();
                }
            }
            for (int c=0; c<B; c++) {
                if (workers[B-1][c] != null) {
                    workers[B-1][c].doWork();
                }
            }

            if (M > 0) {
                int[] newPresent = new int[] {0, 0};
                presents.add(newPresent);
                M--;
            }
        }

        System.out.println(result);
    }

}
