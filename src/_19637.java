import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _19637 {

    private static final List<String> strings = new ArrayList<>();
    private static final List<Integer> values = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        strings.add(".");
        values.add(-1);
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if (values.isEmpty() || values.get(values.size() - 1) <= value) {
                strings.add(str);
                values.add(value);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            int target = Integer.parseInt(br.readLine());
            sb.append(bs(0, N, target));
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static String bs(int left, int right, int value) {
//        System.out.printf("%d %d %d\n", values.get(left), values.get(right), value);
        int mid = (left + right) / 2;

        int leftValue = values.get(left);
        int rightValue = values.get(right);
        int midValue = values.get(mid);

        if (right - left == 1 && leftValue < value && value <= rightValue) {
            return strings.get(right);
        }

        if (midValue < value) {
            return bs(mid, right, value);
        }
        else {
            return bs(left, mid, value);
        }

    }

}
