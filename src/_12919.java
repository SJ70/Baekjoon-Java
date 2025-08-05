import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class _12919 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        String target = br.readLine();
        Set<String> set = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();

        set.add(start);
        q.add(start);

        while (!q.isEmpty()) {
            String s = q.poll();
            String sr = new StringBuilder(s).reverse().toString();

            if (s.length() > target.length()) {
                break;
            }

            if (!target.contains(s) && !target.contains(sr)) {
                continue;
            }

            if (s.equals(target)) {
                System.out.println(1);
                return;
            }

            String s1 = s + "A";
            if (!set.contains(s1)) {
                set.add(s1);
                q.add(s1);
            }

            String s2 = "B" + sr;
            if (!set.contains(s2)) {
                set.add(s2);
                q.add(s2);
            }
        }
        System.out.println(0);

    }

}
