import java.io.*;
import java.util.*;

public class _11509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arrows = new int[1000001];
        int result = 0;
        for(int i=0; i<N; i++){
            int height = Integer.parseInt(st.nextToken());
            if(arrows[height]==0){
                result++;
            }
            else{
                arrows[height]--;
            }
            arrows[height-1]++;
        }
        System.out.println(result);
    }
}
