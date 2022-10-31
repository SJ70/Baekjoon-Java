import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25709 {
    static int N;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        init();
//        System.out.println(N+","+cnt);
        while(N>0){
            MinusOne();
//            System.out.println(N+","+cnt);
            DeleteOne();
//            System.out.println(N+","+cnt);
        }
        System.out.println(cnt);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            int n = str.charAt(i)-'0';
            if(n==1) cnt++;
            else sb.append(n);
        }
        String tmp = sb.toString();
        N = tmp.equals("") ? 0 : Integer.parseInt(tmp);
    }
    public static void MinusOne(){
        int tmp = (N%10==0 ? 10 : N%10) -1;
        N -= tmp;
        cnt += tmp;
    }
    public static void DeleteOne(){
        N /= 10;
        cnt++;
    }
}
