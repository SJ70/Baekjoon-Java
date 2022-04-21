import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2798 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] Cards;
    static int result = 0;
    static int N,M;
    public static void Input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            Cards[i] = Integer.parseInt(st.nextToken());
    }
    public static void Max(int n){
        if(result<n && n<=M) result=n;
    }
    public static int BF(){
        for(int i=0; i<N-2; i++){
            int sum = 0;
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    sum = Cards[i]+Cards[j]+Cards[k];
                    Max(sum);
                    // System.out.println(i+":"+Cards[i]+", "+j+":"+Cards[j]+", "+k+":"+Cards[k]+", "+sum);
                    if(result==M) return result; // 같을 경우 더이상 계산 필요 ㄴ
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        Input();
        System.out.println(BF());;
    }
}
