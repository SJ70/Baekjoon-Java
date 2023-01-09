import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2845 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            sb.append(Integer.parseInt(st.nextToken())-N).append(' ');
        }
        System.out.print(sb);
    }
}
