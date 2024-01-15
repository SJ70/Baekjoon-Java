import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> inCompany = new HashSet<>();
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (inCompany.contains(name)) {
                inCompany.remove(name);
            }
            else {
                inCompany.add(name);
            }
        }
        System.out.println(inCompany.stream().sorted(Collections.reverseOrder()).collect(Collectors.joining("\n")));
    }

}
