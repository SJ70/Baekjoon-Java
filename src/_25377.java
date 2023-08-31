import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int timeToArrive = Integer.parseInt(st.nextToken());
            int timeToBake = Integer.parseInt(st.nextToken());
            if(timeToArrive <= timeToBake){
                result = Math.min(timeToBake, result);
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}
