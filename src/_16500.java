import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _16500 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();

        // 도달한 길이들을 저장 (긴 순서로)
        PriorityQueue<Integer> Q = new PriorityQueue<>((a, b) -> b - a);

        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];
        boolean[] visited = new boolean[target.length() + 1];

        for (int i=0; i<N; i++) {
            strings[i] = br.readLine();

            if (target.equals(strings[i])) {
                System.out.println(1);
                return;
            }

            // 해당 문자열로 시작한다면 큐에 추가
            if (target.startsWith(strings[i])) {
                Q.add(strings[i].length());
                visited[strings[i].length()] = true;
            }
        }

        while (!Q.isEmpty()) {
            int currentIdx = Q.poll();
            loop: for (String str : strings) {

                // 이었을 때 더 길면 안 됨
                if (currentIdx + str.length() > target.length()) {
                    continue;
                }
                // 이미 방문한 위치는 방문하지 않음
                if (visited[currentIdx + str.length()]) {
                    continue;
                }
                for (int i=0; i<str.length(); i++) {
                    if (str.charAt(i) != target.charAt(i + currentIdx)) {
                        continue loop;
                    }
                }
                // 종료 확인
                if (currentIdx + str.length() == target.length()) {
                    System.out.println(1);
                    return;
                }
                // 이었을 때까지 일치한다면 다음 길이를 저장
                Q.add(currentIdx + str.length());
                visited[currentIdx + str.length()] = true;
            }
        }

        System.out.println(0);

    }

}
