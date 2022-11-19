import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17256 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] value = new int[3];
        for(int i=2; i>=0; i--){
            value[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int bx = Integer.parseInt(st.nextToken()) - value[0];
        int by = Integer.parseInt(st.nextToken()) / value[1];
        int bz = Integer.parseInt(st.nextToken()) - value[2];

        System.out.printf("%d %d %d",bx,by,bz);
    }
}
