import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1408 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int from = SecondValueOf(br.readLine());
        int to = SecondValueOf(br.readLine());
        if(from>to) to+=24*60*60;
        String result = TimeValueOf(to-from);
        System.out.println(result);
    }
    public static int SecondValueOf(String str){
        StringTokenizer st = new StringTokenizer(str,":");
        int result = 0;
        result += Integer.parseInt(st.nextToken())*3600;
        result += Integer.parseInt(st.nextToken())*60;
        result += Integer.parseInt(st.nextToken());
        return result;
    }
    public static String TimeValueOf(int n){
        StringBuilder sb = new StringBuilder();
        int H = (n/3600);
        n%=3600;
        if(H<10) sb.append('0');
        sb.append(H).append(':');

        int M = n/60;
        n%=60;
        if(M<10) sb.append('0');
        sb.append(M).append(':');

        int S = n;
        if(S<10) sb.append('0');
        sb.append(S);

        return sb.toString();
    }
}
