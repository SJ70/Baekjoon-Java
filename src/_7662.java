import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _7662 {

    private static class Number implements Comparable<Number>{
        int value;
        boolean deleted;

        public Number(int value) {
            this.value = value;
        }

        public void delete() {
            deleted = true;
        }

        public boolean isDeleted() {
            return deleted;
        }

        public int getValue() {
            return value;
        }

        public int compareTo(Number number) {
//            return value - number.value;  <--  Integer.MIN_VALUE 아래로 값이 내려갈 수 있음
            return Integer.compare(value, number.value);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Number> pq = new PriorityQueue<>();
            PriorityQueue<Number> reversePq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char operation = st.nextToken().charAt(0);
                int number = Integer.parseInt(st.nextToken());

                switch (operation) {
                    case 'I' :
                        // 같은 객체를 양쪽에 집어넣는다
                        Number numberObj = new Number(number);
                        pq.add(numberObj);
                        reversePq.add(numberObj);
                        break;
                    case 'D' :
                        PriorityQueue<Number> pqToPoll = (number == 1) ? reversePq : pq;

                        // 이미 다른 큐에서 삭제된 요소 삭제
                        pollAlreadyDeletedNumbers(pqToPoll);
                        if (!pqToPoll.isEmpty()) {
                            pqToPoll.poll().delete();
                        }
                        break;
                }
            }

            // 남은 쓰레기 요소 정리
            pollAlreadyDeletedNumbers(pq);
            pollAlreadyDeletedNumbers(reversePq);

            sb.append((pq.isEmpty() && reversePq.isEmpty()) ? "EMPTY\n" : String.format("%d %d\n", reversePq.poll().getValue(), pq.poll().getValue()));
        }

        System.out.print(sb);
    }

    private static void pollAlreadyDeletedNumbers(PriorityQueue<Number> pq) {
        while (!pq.isEmpty() && pq.peek().isDeleted()) {
            pq.poll();
        }
    }

}
