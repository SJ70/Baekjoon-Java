import java.io.*;

public class _9020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        Init();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            int a = GetGB(n);
            sb.append(a+" "+(n-a)+"\n");
        }
        System.out.println(sb);
    }
    static boolean[] NotDecimal = new boolean[10001];
    public static void Init(){
        NotDecimal[1]=true;
        for(int i=2; i<=10000; i++){
            if(NotDecimal[i]) continue;
            for(int j=i+i; j<=10000; j+=i){
                if((!NotDecimal[j])){
                    NotDecimal[j]=true;
                }
            }
        }
    }
    public static int GetGB(int n){
        int a = n/2;
        int b = n/2;
        while(a>=0 && b<=n){
            if(!NotDecimal[a]&&!NotDecimal[b]) return a;
            a--;
            b++;
        }
        return -1;
    }
}
