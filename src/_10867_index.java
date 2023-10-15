import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10867_index {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static boolean[] visited = new boolean[2001];

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            visited[getIndexFromNumber(num)] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<=2000; i++) {
            if (!visited[i]){
                continue;
            }
            int num = getNumberFromIndex(i);
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }

    private static int getIndexFromNumber(int number) {
        return number + 1000;
    }

    private static int getNumberFromIndex(int index) {
        return index - 1000;
    }

}
