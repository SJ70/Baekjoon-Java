import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _30885 {

    private static class Node {
        int idx;
        long value;
        long originalValue;

        public Node(int idx, long value) {
            this.idx = idx;
            this.value = this.originalValue = value;
        }

        public boolean canEat(Node node) {
            if (node == null) {
                return false;
            }
            return this.originalValue >= node.value;
        }

        public void eat(Node node) {
            this.value += node.value;
        }

        public void sleep() {
            this.originalValue = this.value;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        Deque<Node> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= length; i++) {
        long value = Long.parseLong(st.nextToken());
            Node node = new Node(i, value);
            deque.add(node);
        }

        while (deque.size() > 1) {
            Deque<Node> nextDeque = getNextDeque(deque);
            if (deque.size() == nextDeque.size()) {
                break;
            }
            deque = nextDeque;
        }

        Node lastNodeStanding = deque.poll();
        System.out.printf("%d\n%d\n", lastNodeStanding.value, lastNodeStanding.idx);
    }

    private static Deque<Node> getNextDeque(Deque<Node> deque) {

        Deque<Node> nextDeque = new ArrayDeque<>();
        while (!deque.isEmpty()) {
            Node currentNode = deque.poll();

            Node previousNode = nextDeque.isEmpty() ? null : nextDeque.peekLast();
            if (currentNode.canEat(previousNode)) {
                currentNode.eat(previousNode);
                nextDeque.pollLast();
            }

            Node nextNode = deque.isEmpty() ? null : deque.peek();
            if (currentNode.canEat(nextNode)) {
                currentNode.eat(nextNode);
                deque.poll();
            }

            nextDeque.addLast(currentNode);
        }

        int length = nextDeque.size();
        for (int i=0; i<length; i++) {
            Node node = nextDeque.poll();
            node.sleep();
            nextDeque.add(node);
        }

        return nextDeque;
    }

}
