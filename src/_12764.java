import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _12764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> schedules = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] schedule = new int[2];
            schedule[0] = Integer.parseInt(st.nextToken());
            schedule[1] = Integer.parseInt(st.nextToken());
            schedules.add(schedule);
        }

        int computerCounts = 0;
        int[] usedCnt = new int[N + 1];
        PriorityQueue<Integer> usableComputers = new PriorityQueue<>(); // 사용 가능한 좌석 번호
        PriorityQueue<int[]> stopUseWhen = new PriorityQueue<>((a, b) -> a[1] - b[1]);    // 좌석 번호 및 사용 종료 시간
        while (!schedules.isEmpty()) {
            int[] schedule = schedules.poll();
            int start = schedule[0];
            int end = schedule[1];

            // 사용 시작 시간 이전까지 사용 종료하는 모든 좌석 정리
            while (!stopUseWhen.isEmpty() && stopUseWhen.peek()[1] <= start) {
                int[] stopUsed = stopUseWhen.poll();
                usableComputers.add(stopUsed[0]);
            }

            int computerNum = (usableComputers.isEmpty())
                    ? ++computerCounts          // 빈 좌석이 없으면 PC 추가
                    : usableComputers.poll();   // 있다면 해당 좌석 사용
            usedCnt[computerNum]++;
            stopUseWhen.add(new int[] {computerNum, end});
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(computerCounts);
        sb.append('\n');
        for (int i = 1; i <= computerCounts; i++) {
            sb.append(usedCnt[i]);
            sb.append((i == computerCounts) ? '\n' : ' ');
        }
        System.out.print(sb);

    }

}
