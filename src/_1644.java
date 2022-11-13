import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _1644 {
    static int N;
    static boolean[] isNotDecimal;
    static ArrayList<Long> Decimal;
    public static void main(String[] args) throws IOException {
        init();
        for(int i=2; i<=N; i++){
            if(!isNotDecimal[i])
                setDecimal(i);
        }
//        for(int i=0; i<=N; i++) System.out.printf("%3d:%S\n",i,isNotDecimal[i]?"":"소수");
//        for(long element : DecimalPrefixSum) System.out.println(element);
        System.out.println(getResult());
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        isNotDecimal = new boolean[N+1];
        Decimal = new ArrayList<>();

        isNotDecimal[0] = isNotDecimal[1] = true;
    }
    public static void setDecimal(int n){
        Decimal.add((long)n);
        for(int i=n+n; i<=N; i+=n){
            isNotDecimal[i] = true;
        }
    }
    public static int getResult(){
        int result = 0;
        int from = Decimal.size()-1;
        if(from==-1) return 0;
        int until = from;

        long value = Decimal.get(from);
        while(true){
            if(value==N){
//                System.out.printf("%d~%d\n",Decimal.get(from),Decimal.get(until));
                result++;
            }

            if(value>N){
                value-=Decimal.get(until);
                until--;
            }
            else{
                if(from==0) break;
                from--;
                value+=Decimal.get(from);
            }
        }
        return result;
    }
}
