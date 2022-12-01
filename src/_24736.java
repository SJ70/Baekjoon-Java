import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] Score = {6,3,2,1,2};
        for(int t=0; t<2; t++){
            int score = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<5; i++){
                score += Score[i] * Integer.parseInt(st.nextToken());
            }
            System.out.printf("%d ",score);
        }
    }
}
