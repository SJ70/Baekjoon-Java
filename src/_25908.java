import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25908 {
    static int from,to;
    public static void main(String[] args) throws IOException{
        init();
        int result = -(to-from+1);
        for(int divisor=2; divisor<=to; divisor++){
            int tmp = (divisor%2==0)?1:-1;
            for(int N=divisor; N<=to; N+=divisor){
                if(N>=from){
                    //System.out.printf("%d/%d\n",N,divisor);
                    result += tmp;
                }
            }
        }
        System.out.print(result);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());
    }
}
