import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20254 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] Score = {56,24,14,6};
        int resultScore = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            resultScore += Integer.parseInt(st.nextToken()) * Score[i];
        }
        System.out.println(resultScore);
    }
}
