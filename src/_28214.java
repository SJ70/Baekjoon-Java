import java.io.*;
import java.util.StringTokenizer;

public class _28214 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int result = 0;
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            int p = 0;
            for(int k=0; k<K; k++){
                if(st.nextToken().charAt(0)=='0'){
                    p++;
                }
            }
            if(p<P){
                result++;
            }
        }

        System.out.println(result);
    }
}
