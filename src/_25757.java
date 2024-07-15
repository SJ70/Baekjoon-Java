import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _25757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        int requiredMemberCnt = game=='Y' ? 1 : game=='F' ? 2 : 3;

        Set<String> names = new HashSet<>();
        for (int i=0; i<N; i++) {
            String name = br.readLine();
            names.add(name);
        }

        System.out.println(names.size() / requiredMemberCnt);

    }

}
