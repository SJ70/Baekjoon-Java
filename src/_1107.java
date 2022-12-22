import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1107 {
    static int wannaGo;
    static boolean[] disabled = new boolean[10];
    static boolean disabledAll;
    public static void main(String[] args) throws IOException{
        init();
        if(disabledAll) System.out.println(Math.abs(wannaGo-100));
        else System.out.println(Math.min(Math.abs(wannaGo-100),solve()));
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wannaGo = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        if(n==10) disabledAll=true;
        if(n>0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                disabled[Integer.parseInt(st.nextToken())] = true;
            }
        }
    }
    public static boolean canGo(int n){
        if(n==0) return !disabled[0];
        for(; n>0; n/=10){
            if(disabled[n%10]) return false;
        }
        return true;
    }
    public static long solve(){
        int left = wannaGo;
        int right = wannaGo;
        while(true){
//            System.out.println(left+","+right);
            if(left>=0){
                if(canGo(left)) return (digitOf(left)+(wannaGo-left));
                else left--;
            }
            if(canGo(right)) return (digitOf(right)+(right-wannaGo));
            else right++;
        }
    }
    public static int digitOf(int n){
        if(n==0) n++;
        return (int)Math.log10(n)+1;
    }
}
