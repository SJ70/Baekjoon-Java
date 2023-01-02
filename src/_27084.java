import java.io.*;
import java.util.StringTokenizer;

public class _27084 {
    public static void main(String[] args) throws IOException{
        init();
        System.out.println(getResult());   // 카드를 뽑지 않은 경우 배제
    }
    static int N;
    static int[] cards;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cards[Integer.parseInt(st.nextToken())]++;
        }
    }
    public static long getResult(){
        long result = 1;
        for(int element : cards){
            if(element>0){
                result *= (element+1);
                result %= 1000000007;
            }
        }
        result--;
        return result;
    }
}
