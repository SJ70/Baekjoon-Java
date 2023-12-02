// 그리디
// 각각의 현재 인덱스 보다 뒤에 있는 공통된 가장 높은 숫자를 찾는다
// ㄴ 반복

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class _30805 {

    private static class NumberIndex {
        public final int value;
        public final int index;

        public NumberIndex(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            return value+"("+index+")";
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static PriorityQueue<NumberIndex> A;
    private static PriorityQueue<NumberIndex> B;
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        A = inputNumbers();
        B = inputNumbers();

        int lastAIndex = -1;
        int lastBIndex = -1;

        NumberIndex a = A.poll();
        NumberIndex b = B.poll();

        // 가장 큰 같은 수를 찾는다.
        while (true) {
//            System.out.println(a);
//            System.out.println(b);
//
//            System.out.println(A);
//            System.out.println(B);
//            System.out.println();

            // b가 a보다 크다면 다음 b를 호출 || 인덱스가 이전 인덱스일 경우
            if (b.value > a.value || b.index < lastBIndex) {
                if (B.isEmpty()) {
                    break;
                }
                b = B.poll();
                continue;
            }

            // a가 b보다 크다면 다음 a를 호출 || 인덱스가 이전 인덱스일 경우
            if (b.value < a.value || a.index < lastAIndex) {
                if (A.isEmpty()) {
                    break;
                }
                a = A.poll();
                continue;
            }

            // 같다면 결과에 추가
            if (a.value == b.value) {
                lastAIndex = a.index;
                lastBIndex = b.index;
                result.add(a.value);
                if (A.isEmpty() || B.isEmpty()) {
                    break;
                }
                a = A.poll();
                b = B.poll();
            }

        }

        System.out.printf(
                "%s\n%s\n",
                result.size(),
                result.stream().map(String::valueOf).collect(Collectors.joining(" "))
        );

    }

    private static PriorityQueue<NumberIndex> inputNumbers() throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i <n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        PriorityQueue<NumberIndex> pq = new PriorityQueue<>((o1, o2) -> {
            int diff = o2.value - o1.value;
            if (diff == 0) {
                return o1.index - o2.index;
            }
            return diff;
        });
        IntStream.range(0, numbers.size())
                .mapToObj(index -> new NumberIndex(numbers.get(index), index))
                .forEach(pq::add);
        return pq;
    }

}
