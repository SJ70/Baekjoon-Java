import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25858 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int total = 0;
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
            total += value;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(money * arr[i] / total);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
