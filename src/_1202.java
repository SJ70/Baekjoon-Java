import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1202 {

    private static int jewelCnt;
    private static int bagCnt;

    private static class Jewel {
        int weight, price;
        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
    private static PriorityQueue<Jewel> jewels = new PriorityQueue<>((a, b) -> b.price - a.price);
    private static int[] bags;

    private static class SegmentNode {
        int min, max;
    }
    private static int segmentTreeSize;
    private static SegmentNode[] bagsSegmentTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        jewelCnt = Integer.parseInt(st.nextToken());
        bagCnt = Integer.parseInt(st.nextToken());

        // input
        for (int i=0; i<jewelCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(weight, price));
        }
        bags = new int[bagCnt];
        for (int i=0; i<bagCnt; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bags);

        // init segment tree
        segmentTreeSize = 1;
        while (segmentTreeSize < bags.length) {
            segmentTreeSize *= 2;
        }
        segmentTreeSize *= 2;
        bagsSegmentTree = new SegmentNode[segmentTreeSize];
        // fill bag size
        for (int i=0; i<bagCnt; i++) {
            int idx = segmentTreeSize/2 + i;
            bagsSegmentTree[idx] = new SegmentNode();
            bagsSegmentTree[idx].min = bags[i];
            bagsSegmentTree[idx].max = bags[i];
        }
        // fill tree
        for (int i=segmentTreeSize/2 - 1; i>=1; i--) {
            bagsSegmentTree[i] = new SegmentNode();
            updateNode(i);
        }

//        printTree();

        // fill jewel
        int filledBagCnt = 0;
        long entirePrice = 0;
        loop: while (!jewels.isEmpty() && filledBagCnt < bagCnt) {
            Jewel jewel = jewels.poll();
//            System.out.printf("\nweight: %d, price: %d\n", jewel.weight, jewel.price);

            // 넣을 수 있는 가장 작은 가방에 삽입
            int i = 1;
            while (true) {

                SegmentNode cur = bagsSegmentTree[i];
                // 넣을 수 있는 가방이 없음
                if (cur.max < jewel.weight) {
                    // 해당 보석 탈락
                    continue loop;
                }

                // 가방에 도달
                if (i >= segmentTreeSize/2) {
                    bagsSegmentTree[i] = null;
                    filledBagCnt++;
                    entirePrice += jewel.price;
                    // 트리 수정
                    i /= 2;
                    while (i >= 1) {
                        updateNode(i);
                        i /= 2;
                    }
//                    printTree();
                    continue loop;
                }

                int leftIdx = i * 2;
                int rightIdx = i * 2 + 1;
                SegmentNode left = bagsSegmentTree[leftIdx];
                SegmentNode right = bagsSegmentTree[rightIdx];

                if (left == null) {
                    i = rightIdx;
                }
                else if (right == null) {
                    i = leftIdx;
                }
                else if (left.max >= jewel.weight) {
                    // 더 작은 가방에 넣는 게 우선
                    i = leftIdx;
                }
                else {
                    // 안 되면 큰 곳에
                    i = rightIdx;
                }
            }

        }

        System.out.println(entirePrice);

    }

    private static void updateNode(int i) {
        SegmentNode left = bagsSegmentTree[i*2];
        SegmentNode right = bagsSegmentTree[i*2+1];
        if (left == null && right == null) {
            bagsSegmentTree[i] = null;
        }
        else if (left == null) {
            bagsSegmentTree[i] = right;
        }
        else if (right == null) {
            bagsSegmentTree[i] = left;
        }
        else {
            bagsSegmentTree[i].min = Math.min(left.min, right.min);
            bagsSegmentTree[i].max = Math.max(left.max, right.max);
        }
    }

//    private static void printTree() {
//        int from = 1;
//        int length = 1;
//        while (true) {
//            for (int i=from; i<from + length; i++) {
//                int spaceCnt = (segmentTreeSize / (from + length) - 1) * 4;
//                System.out.print(" ".repeat(spaceCnt));
//                System.out.printf(
//                        "(%s,%s) ",
//                        bagsSegmentTree[i] == null ? "  " : String.format("%2d", bagsSegmentTree[i].min),
//                        bagsSegmentTree[i] == null ? "  " : String.format("%2d", bagsSegmentTree[i].max)
//                );
//                System.out.print(" ".repeat(spaceCnt));
//            }
//            System.out.println();
//            from = from + length;
//            length *= 2;
//            if (from >= segmentTreeSize) {
//                break;
//            }
//        }
//    }

}
