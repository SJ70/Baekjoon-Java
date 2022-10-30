import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _25905 {
    static final int N = 10;
    static double[] ReinforcePercent;
    public static void main(String[] args) throws IOException{
        init();
        System.out.print(getResult()*1000000000f);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ReinforcePercent = new double[N];
        for(int i=0; i<N; i++){
            ReinforcePercent[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(ReinforcePercent);
    }
    public static double getResult(){
        double result = 1f;
        for(int i=1; i<N; i++){
            result *= ReinforcePercent[N-i]/(double)i;
        }
        return result;
    }
}
