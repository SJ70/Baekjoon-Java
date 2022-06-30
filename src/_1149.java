import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] Map;
    static int T;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        Map = new int[T+1][3];

        for(int r=1; r<=T; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map[r][0] = Integer.parseInt(st.nextToken()) + Math.min(Map[r-1][1],Map[r-1][2]);
            Map[r][1] = Integer.parseInt(st.nextToken()) + Math.min(Map[r-1][0],Map[r-1][2]);
            Map[r][2] = Integer.parseInt(st.nextToken()) + Math.min(Map[r-1][0],Map[r-1][1]);
            //System.out.printf("%d %d %d\n",Map[r][0],Map[r][1],Map[r][2]);
        }

        System.out.println(Math.min(Map[T][0],Math.min(Map[T][1],Map[T][2])));
    }
}
