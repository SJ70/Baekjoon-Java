import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11723 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] arr = new boolean[21];

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            switch (operation) {
                case "add" :
                    arr[Integer.parseInt(st.nextToken())] = true;
                    break;
                case "remove" :
                    arr[Integer.parseInt(st.nextToken())] = false;
                    break;
                case "check" :
                    sb.append(arr[Integer.parseInt(st.nextToken())] ? 1 : 0);
                    sb.append('\n');
                    break;
                case "toggle" :
                    int k = Integer.parseInt(st.nextToken());
                    arr[k] = !arr[k];
                    break;
                case "all" :
                    Arrays.fill(arr, true);
                    break;
                case "empty" :
                    Arrays.fill(arr, false);
                    break;
            }
        }
        System.out.print(sb);

    }

}
