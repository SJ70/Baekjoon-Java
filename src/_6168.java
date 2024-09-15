import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6168 {

    private static class Node {
        int oneCntLeft;
        int twoCntLeft;
        int oneCntRight;
        int twoCntRight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Node[] nodes = new Node[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            nodes[i] = new Node();
        }
        for (int i=0; i<N; i++) {
            nodes[i].oneCntLeft = (i>0 ? nodes[i-1].oneCntLeft : 0) + (arr[i] == 1 ? 1 : 0);
            nodes[i].twoCntLeft = (i>0 ? nodes[i-1].twoCntLeft : 0) + (arr[i] == 2 ? 1 : 0);
        }
        for (int i=N-1; i>=0; i--) {
            nodes[i].oneCntRight = (i<N-1 ? nodes[i+1].oneCntRight : 0) + (arr[i] == 1 ? 1 : 0);
            nodes[i].twoCntRight = (i<N-1 ? nodes[i+1].twoCntRight : 0) + (arr[i] == 2 ? 1 : 0);
        }
        int minResult = Integer.MAX_VALUE;
        for (int i=0; i<N; i++) {
//            System.out.printf("%d : %d %d %d %d\n", arr[i], nodes[i].oneCntLeft, nodes[i].twoCntLeft, nodes[i].oneCntRight, nodes[i].twoCntRight);
            int result = nodes[i].twoCntLeft + nodes[i].oneCntRight - 1;
            minResult = Math.min(minResult, result);
        }
        System.out.println(minResult);

    }

}
