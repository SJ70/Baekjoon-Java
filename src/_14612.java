import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _14612 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]> arr = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "order" :
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    arr.add(new int[] {a, b});
                    break;
                case "sort" :
                    arr.sort((o1, o2) -> (o1[1] == o2[1]) ? (o1[0] - o2[0]) : (o1[1] - o2[1]));
                    break;
                case "complete" :
                    int c = Integer.parseInt(st.nextToken());
                    arr = arr.stream()
                            .filter(array -> array[0] != c)
                            .collect(Collectors.toList());
                    break;
            }
            if (arr.isEmpty()) {
                sb.append("sleep");
            } else {
                sb.append(arr.stream().map(o -> o[0]).map(String::valueOf).collect(Collectors.joining(" ")));
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
