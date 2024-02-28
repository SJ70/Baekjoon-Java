import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1966 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static class Document {
        int priority;
        int idx;

        public Document(int priority, int i) {
            this.priority = priority;
            this.idx = i;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            sb.append(getResult());
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static int getResult() throws IOException {

        PriorityQueue<Integer> documentPriorities = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Document> documents = new ArrayDeque<>();

        // input
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int findingDocumentIdx = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int documentPriority = Integer.parseInt(st.nextToken());
            documentPriorities.add(documentPriority);
            documents.add(new Document(documentPriority, i));
        }

        // logic
        for (int i=0; true;) {
            Document d = documents.poll();
            if (d.priority >= documentPriorities.peek()) {
                documentPriorities.poll();
                i++;
                if (d.idx == findingDocumentIdx) {
                    return i;
                }
            }
            else {
                documents.add(d);
            }
        }
    }

}
