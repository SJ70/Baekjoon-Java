import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1037 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); //N

        int min = 9999999;
        int max = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            if(n<min) min=n;
            if(n>max) max=n;
        }

        System.out.println(max*min);
    }
}
