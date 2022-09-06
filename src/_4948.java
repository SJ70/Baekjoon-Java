import java.io.*;

public class _4948 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Init();
        int n;
        while( (n=Integer.parseInt(br.readLine()))>0 ){
            sb.append(Decimal[n*2]-Decimal[n]+"\n");
        }
        System.out.println(sb);
    }
    static final int N = 123456*2;
    static boolean[] NotDecimal = new boolean[N+1];
    static int[] Decimal = new int[N+1];
    public static void Init(){
        NotDecimal[0]=true;
        NotDecimal[1]=true;
        for(int i=2; i<=N; i++){
            for(int j=i*2; j<=N; j+=i){
                if(!NotDecimal[j])
                    NotDecimal[j]= true;
            }
        }
        Decimal[2]=1;
        for(int i=3; i<=N; i++){
            if(NotDecimal[i]){
                Decimal[i]=Decimal[i-1];
            }
            else{
                Decimal[i]=Decimal[i-1]+1;
            }
        }
    }
}