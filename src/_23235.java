import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _23235 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int i = 1;
        while(init()){
            sb.append("Case ").append(i).append(": Sorting... done!\n");
            i++;
        }
        System.out.println(sb);
    }
    public static boolean init() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        return N!=0;
    }
}
