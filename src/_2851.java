import java.io.*;

public class _2851 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int result = 0;
    public static int Dif(int n){
        return Math.abs(100-n);
    }
    public static boolean GoCloser(int n){
        return Dif(result)>=Dif(result+n);
    }
    public static void main(String[] args) throws IOException{
        for(int i=0; i<10; i++){
            int n = Integer.parseInt(br.readLine());
            if(GoCloser(n))
                result+=n;
            else break;
        }
        System.out.println(result);
    }
}
